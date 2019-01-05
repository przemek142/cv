package przemek.portfel.Models.ExchangeRate;

import lombok.Data;

import java.math.BigDecimal;

@Data // getters, setters, etc.
public class JsonSingleRateData {
    private String no;
    // date of exchange rate "2019-01-02"
    private String effectiveDate;
    // average exchange rate "3.8242"
    private BigDecimal mid;

    // no param constructor
    public JsonSingleRateData() {
    }
}
