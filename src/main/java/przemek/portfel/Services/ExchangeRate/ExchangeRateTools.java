package przemek.portfel.Services.ExchangeRate;

import com.fasterxml.jackson.databind.ObjectMapper;
import przemek.portfel.Models.ExchangeRate.JsonSingleRate;
import przemek.portfel.Models.ExchangeRate.SingleRate;
import przemek.portfel.Repositories.ExchangeRate.ExchangeRateRepo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * static tools for exchange rates
 */
public class ExchangeRateTools {

    /**
     * JSON OBJECT (JsonSingleRate) -> OBJECT (SingleRate)
     * @param jsonSingleRate output from object mapper, ref.: {@link #getRate(String, String, ObjectMapper)}, {@link #getRate(LocalDate, String, ObjectMapper)}, {@link #getRate(String, ObjectMapper)}
     * @return singleRate object
     */
    public static SingleRate json2obj(JsonSingleRate jsonSingleRate) {
        SingleRate singleRate = new SingleRate();
        singleRate.setCode(jsonSingleRate.getCode());
        singleRate.setCurrency(jsonSingleRate.getCurrency());
        singleRate.setEffectiveDate(jsonSingleRate.getRates()[0].getEffectiveDate());
        singleRate.setTable(jsonSingleRate.getTable());
        singleRate.setNo(jsonSingleRate.getRates()[0].getNo());
        singleRate.setMid(jsonSingleRate.getRates()[0].getMid());
        return singleRate;
    }

    /**
     * Get rate from NBP with LocaDdate
     * @param localDate date for exchange rate
     * @param currency currency of exchange rate
     * @param objectMapper ObjectMapper instance
     * @return JsonSingleRate object
     * @throws IOException
     */
    public static JsonSingleRate getRate(LocalDate localDate, String currency, ObjectMapper objectMapper) throws IOException {
        // e.g. http://api.nbp.pl/api/exchangerates/rates/a/chf/2016-04-02/?format=json
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String url =
                "http://api.nbp.pl/api/exchangerates/rates/a/" +
                        currency + "/" +
                        localDate.format(formatter) +
                        "/?format=json";
        return objectMapper.readValue(new URL(url), JsonSingleRate.class);
    }

    /**
     * Get rate from NBP with String date ("yyyy-MM-dd"), overloaded {@link #getRate(LocalDate, String, ObjectMapper)} method
     * @param localDate date for exchange rate
     * @param currency currency of exchange rate
     * @param objectMapper ObjectMapper instance
     * @return JsonSingleRate object
     * @throws IOException
     */
    public static JsonSingleRate getRate(String localDate, String currency, ObjectMapper objectMapper) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return getRate(LocalDate.parse(localDate, formatter), currency, objectMapper);
    }

    /**
     * Get rate from NBP with today as date, overloaded {@link #getRate(LocalDate, String, ObjectMapper)} method
     * @param currency date for exchange rate
     * @param objectMapper currency of exchange rate
     * @return ObjectMapper instance
     * @throws IOException
     */
    public static JsonSingleRate getRate(String currency, ObjectMapper objectMapper) throws IOException {
        // http://api.nbp.pl/api/exchangerates/rates/a/chf/2016-04-02/?format=json
        String url =
                "http://api.nbp.pl/api/exchangerates/rates/a/" +
                        currency +
                        "/?format=json";
        return objectMapper.readValue(new URL(url), JsonSingleRate.class);

    }

    /**
     * Check if singleRate object exist in DB
     * @param singleRate input rate
     * @param exchangeRateRepo ExchangeRateRepo repository
     * @return
     */
    public static boolean exist(SingleRate singleRate, ExchangeRateRepo exchangeRateRepo) {
        List<SingleRate> list = exchangeRateRepo.findAll();
        boolean exist = false;

        for (SingleRate rate : list) {
            if (singleRate.equals(rate)) {
                exist = true;
            }
        }
        return exist;
    }



}
