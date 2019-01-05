package przemek.portfel.Services.ExchangeRate;

import com.fasterxml.jackson.databind.ObjectMapper;
import przemek.portfel.Models.Exceptions.CurrencyGetURLException;
import przemek.portfel.Models.ExchangeRate.JsonSingleRate;
import przemek.portfel.Models.ExchangeRate.SingleRate;
import przemek.portfel.Repositories.ExchangeRate.ExchangeRateRepo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExchangeRateTools {


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

    public static JsonSingleRate getRate(LocalDate localDate, String currency, ObjectMapper objectMapper) throws IOException {
        // http://api.nbp.pl/api/exchangerates/rates/a/chf/2016-04-02/?format=json
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String url =
                "http://api.nbp.pl/api/exchangerates/rates/a/" +
                        currency + "/" +
                        localDate.format(formatter) +
                        "/?format=json";
        return objectMapper.readValue(new URL(url), JsonSingleRate.class);


    }

    public static JsonSingleRate getRate(String localDate, String currency, ObjectMapper objectMapper) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return getRate(LocalDate.parse(localDate, formatter), currency, objectMapper);
    }

    public static JsonSingleRate getRate(String currency, ObjectMapper objectMapper) throws IOException {
        // http://api.nbp.pl/api/exchangerates/rates/a/chf/2016-04-02/?format=json
        String url =
                "http://api.nbp.pl/api/exchangerates/rates/a/" +
                        currency +
                        "/?format=json";
        return objectMapper.readValue(new URL(url), JsonSingleRate.class);

    }

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
