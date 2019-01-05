package przemek.portfel.Currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import przemek.portfel.Repositories.ExchangeRate.ExchangeRateRepo;
import sun.util.resources.sr.CurrencyNames_sr_RS;

public class GetTest {

    @RunWith(SpringRunner.class)
    @DataJpaTest
    public class CurrencyRepositoryIntegrationTest {


        private TestEntityManager entityManager;
        private ExchangeRateRepo exchangeRateRepo;

        @Autowired
        public CurrencyRepositoryIntegrationTest(ExchangeRateRepo exchangeRateRepo, TestEntityManager entityManager) {
            this.exchangeRateRepo = exchangeRateRepo;
            this.entityManager = entityManager;
        }

//        @Test
//        private void test1() {
//            entityManager.
//        }
    }
}
/*
        // given
    Employee alex = new Employee("alex");
    entityManager.persist(alex);
    entityManager.flush();
 
    // when
    Employee found = employeeRepository.findByName(alex.getName());
 
    // then
    assertThat(found.getName())
      .isEqualTo(alex.getName());
        */


