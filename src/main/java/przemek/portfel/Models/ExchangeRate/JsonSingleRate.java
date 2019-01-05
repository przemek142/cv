package przemek.portfel.Models.ExchangeRate;

import lombok.Data;

@Data // getters, setters, etc.
public class JsonSingleRate {


    private Character table;
    // Currency name "frank szwajcarski"
    private String currency;
    // currency code "CHF"
    private String code;
    // data for currency rate (no, effectiveDate, mid)
    private JsonSingleRateData[] rates;

    // no param constructor
    public JsonSingleRate() {
    }

    public JsonSingleRateData[] getRates() {
        return rates;
    }

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
