package przemek.portfel.Repositories.ExchangeRate;

import org.springframework.data.jpa.repository.JpaRepository;
import przemek.portfel.Models.ExchangeRate.SingleRate;

import java.time.LocalDate;

/**
 * interface for SingleRate repository
 */
public interface ExchangeRateRepo extends JpaRepository<SingleRate, Long> {

    /**
     * for finding single currency rate in DB
     * @param code String, eg . "USD"
     * @param effectiveDate LocalDate
     * @return SingleRat, ref.: {@link SingleRate}
     */
    SingleRate findByCodeIsAndEffectiveDateEquals(String code, LocalDate effectiveDate);
}
