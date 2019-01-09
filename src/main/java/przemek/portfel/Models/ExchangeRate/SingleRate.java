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


/**
 * SingleRate.class is an entity for storing single exchange rate in DB
 */
@Entity
@Getter
@Setter
@ToString
public class SingleRate {

    /**
     * SQL ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * used table e.g.: "A"
     */
    private Character table;
    /**
     * Currency name e.g.: "frank szwajcarski"
     */
    private String currency;
    /**
     * currency code e.g.: "CHF"
     */
    private String code;
    /**
     * number (id) of rate e.g.: "001/A/NBP/2019"
     */
    private String no;
    /**
     * date of exchange rate e.g.: "2019-01-02"
     */
    private LocalDate effectiveDate;
    /**
     * average exchange rate e.g.: "3.8242"
     */
    @Digits(integer = 4, fraction = 4)
    private BigDecimal mid;

    /**
     * getter effectiveDate
     *
     * @return LocalDate ref.:{@link #effectiveDate}
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * setter effectiveDate for String value
     *
     * @param effectiveDate {@link #effectiveDate}
     */
    public void setEffectiveDate(String effectiveDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.effectiveDate = LocalDate.parse(effectiveDate, formatter);
    }

    /**
     * setter effectiveDate
     *
     * @param effectiveDate {@link #effectiveDate}
     */
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * no param. constructor
     */
    public SingleRate() {
    }

    /**
     * equals without DB id
     *
     * @param o object to compare
     * @return eqals
     */
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

    /**
     * hashCode without DB id
     *
     * @return int hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(table, currency, code, effectiveDate, mid);
    }
}
