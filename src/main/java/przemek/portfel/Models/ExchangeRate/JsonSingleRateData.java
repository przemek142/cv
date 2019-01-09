package przemek.portfel.Models.ExchangeRate;

import lombok.Data;

import java.math.BigDecimal;

/**
 * JsonSingleRateData.class ref.: {@link JsonSingleRate#rates}
 */
@Data
public class JsonSingleRateData {
    /**
     * id, e.g.: "001/A/NBP/2018"
     */
    private String no;
    /**
     * date of exchange rate, e.g.: "2019-01-02"
     */
    private String effectiveDate;
    /**
     * average exchange rate, e.g.: "3.8242"
     */
    private BigDecimal mid;

    /**
     * no param. constructor
     */
    public JsonSingleRateData() {
    }
}
