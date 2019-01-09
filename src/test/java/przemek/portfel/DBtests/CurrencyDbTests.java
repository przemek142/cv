package przemek.portfel.DBtests;

import static junit.framework.TestCase.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import przemek.portfel.Models.ExchangeRate.SingleRate;
import przemek.portfel.Repositories.ExchangeRate.ExchangeRateRepo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyDbTests {
    Logger logger = LoggerFactory.getLogger(CurrencyDbTests.class);
    SingleRate givenSingleRate;
    SingleRate givenSingleRate2;
    ObjectMapper objectMapper;

    @Autowired
    private ExchangeRateRepo exchangeRateRepo;

    @Before
    public void init() {
        objectMapper = new ObjectMapper();
        //  http://api.nbp.pl/api/exchangerates/rates/a/chf/2018-01-02/?format=json
        givenSingleRate = new SingleRate();
        givenSingleRate.setCode("USD");
        givenSingleRate.setCurrency("dolar amerykański");
        givenSingleRate.setTable('A');
        givenSingleRate.setNo("001/A/NBP/2018");
        givenSingleRate.setEffectiveDate("2018-01-02");
        givenSingleRate.setMid(new BigDecimal("3.4546"));

        givenSingleRate2 = new SingleRate();
        givenSingleRate2.setCode("CHF");
        givenSingleRate2.setCurrency("frank szwajcarski");
        givenSingleRate2.setTable('A');
        givenSingleRate2.setNo("001/A/NBP/2018");
        givenSingleRate2.setEffectiveDate("2018-01-02");
        givenSingleRate2.setMid(new BigDecimal("3.5567"));

        exchangeRateRepo.save(givenSingleRate);
        exchangeRateRepo.save(givenSingleRate2);
    }


    @Test
    public void findAllDbTest() {
        List<SingleRate> list = exchangeRateRepo.findAll();

        boolean firstFound = false, secondFound = false;

        for (SingleRate singleRate : list) {
            if (givenSingleRate.equals(singleRate))
                firstFound = true;
            if (givenSingleRate2.equals(singleRate))
                secondFound = true;
        }

        boolean result = firstFound && secondFound;
        assert (result);
    }

    @Test
    public void findByDateAndCode() {

        SingleRate singleRate = exchangeRateRepo.findByCodeIsAndEffectiveDateEquals("USD", LocalDate.parse("2018-01-02"));
        assertEquals(singleRate, givenSingleRate);
    }
}
