package przemek.portfel.Models.ExchangeRate;

import lombok.Data;

/**
 * JsonSingleRate.class and JsonSingleRateData.class are uses for mapping objects from Json to SingleRate.class.
 */
@Data // getters, setters, etc.
public class JsonSingleRate {

    /**
     * NBP table code, e.g.: "A"
     */
    private Character table;
    /**
     * Currency name , e.g.: "frank szwajcarski"
     */
    private String currency;
    /**
     * currency code, e.g.: "CHF"
     */
    private String code;
    /**
     * data for currency rate (no, effectiveDate, mid)
     * ref.: {@link JsonSingleRateData}
     */
    private JsonSingleRateData[] rates;

    /**
     * no param. constructor
     */
    public JsonSingleRate() {
    }

    /**
     * getter for rates {@link #rates}
     * @return Array of rates
     */
    public JsonSingleRateData[] getRates() {
        return rates;
    }

    /**
     * setter for rates
     * @param rates {@link #rates}
     */
    public void setRates(JsonSingleRateData[] rates) {
        this.rates = rates;
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
