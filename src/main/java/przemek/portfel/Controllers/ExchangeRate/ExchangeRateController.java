package przemek.portfel.Controllers.ExchangeRate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import przemek.portfel.Models.Exceptions.CurrencyGetURLException;
import przemek.portfel.Services.ExchangeRate.ExchangeRateTools;
import przemek.portfel.Models.ExchangeRate.SingleRate;
import przemek.portfel.Repositories.ExchangeRate.ExchangeRateRepo;

import java.io.IOException;
import java.util.List;

// for tests only
@RequestMapping("/exchange")
@RestController
public class ExchangeRateController {

    //     repos injection into contructor
    private ExchangeRateRepo exchangeRateRepo;

    public ExchangeRateController(ExchangeRateRepo exchangeRateRepo) {
        this.exchangeRateRepo = exchangeRateRepo;
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/")
    public SingleRate getRate() {
        SingleRate singleRate = null;
        try {
            singleRate = ExchangeRateTools.json2obj(ExchangeRateTools.getRate("chf", objectMapper));

//        SingleRate singleRate = ExchangeRateTools.json2obj(ExchangeRateTools.getRate("2019-01-02", "chf", objectMapper));

            List<SingleRate> listOfRates = exchangeRateRepo.findAll();

            if (!ExchangeRateTools.exist(singleRate, exchangeRateRepo))
                exchangeRateRepo.save(singleRate);
        } catch (Exception e) {
            throw new CurrencyGetURLException(e);
        }

        return singleRate;
    }
}
