package przemek.portfel.Currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import przemek.portfel.Models.ExchangeRate.SingleRate;
import przemek.portfel.Services.ExchangeRate.ExchangeRateTools;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;

public class GetCurrencyTests {
    SingleRate givenSingleRate;
    ObjectMapper objectMapper;
    LocalDate date;

    @Before
    public void init() {
        date = LocalDate.of(2018,01,02);
        objectMapper = new ObjectMapper();
        //  http://api.nbp.pl/api/exchangerates/rates/a/chf/2018-01-02/?format=json
        givenSingleRate = new SingleRate();
        givenSingleRate.setCode("CHF");
        givenSingleRate.setCurrency("frank szwajcarski");
        givenSingleRate.setTable('A');
        givenSingleRate.setNo("001/A/NBP/2018");
        givenSingleRate.setEffectiveDate("2018-01-02");
        givenSingleRate.setMid(new BigDecimal("3.5567"));

    }

    @Test
    public void getByDateStringAndCode() throws IOException {

        SingleRate testedSingleRate = ExchangeRateTools.json2obj(ExchangeRateTools.getRate(
                "2018-01-02", "CHF", objectMapper));
        assertEquals(testedSingleRate, givenSingleRate);
    }

    @Test
    public void getByLocalDateAndCode() throws IOException {
        SingleRate testedSingleRate = ExchangeRateTools.json2obj(ExchangeRateTools.getRate(
                date, "CHF", objectMapper));

        assertEquals(testedSingleRate, givenSingleRate);

    }
}