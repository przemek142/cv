package przemek.portfel.Repositories.ExchangeRate;

import org.springframework.data.jpa.repository.JpaRepository;
import przemek.portfel.Models.ExchangeRate.SingleRate;

public interface ExchangeRateRepo extends JpaRepository<SingleRate, Long> {
}
