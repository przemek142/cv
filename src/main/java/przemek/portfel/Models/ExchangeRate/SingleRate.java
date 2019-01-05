package przemek.portfel.Models.ExchangeRate;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class SingleRate {

    // SQL ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // used table 'A'
    private Character table;
    // Currency name "frank szwajcarski"
    private String currency;
    // currency code "CHF"
    private String code;
    // data for currency rate (no, effectiveDate, mid)
//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "id")
//            //(cascade = CascadeType.ALL, mappedBy="singleRate")
    // number (id) of rate "001/A/NBP/2019"
    private String no;
    // date of exchange rate "2019-01-02"
    private LocalDate effectiveDate;
    // average exchange rate "3.8242"
    @Digits(integer=4, fraction=4)
    private BigDecimal mid;

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.effectiveDate = LocalDate.parse(effectiveDate, formatter);
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    // no param constructor
    public SingleRate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleRate that = (SingleRate) o;
        return Objects.equals(table, that.table) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(code, that.code) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(mid, that.mid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, currency, code, effectiveDate, mid);
    }

    /*
    example json input:

    {
    "table":"A",
    "currency":"frank szwajcarski",
    "code":"CHF",
    "rates":
      [
          {
            "no":"001/A/NBP/2019",
            "effectiveDate":"2019-01-02",
            "mid":3.8242
           }
       ]
     }
     */
}
