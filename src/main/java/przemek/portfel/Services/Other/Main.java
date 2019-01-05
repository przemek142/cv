package przemek.portfel.Services.Other;

import przemek.portfel.Models.ExchangeRate.SingleRate;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        SingleRate s1 = new SingleRate();
        SingleRate s2 = new SingleRate();

        s1.setEffectiveDate("2015-01-01");
        s1.setMid(new BigDecimal("3.232"));
        s1.setNo("a");
        s1.setTable('A');
        s1.setCurrency("AAA");
        s1.setCode("CSS");
        s1.setId(1l);

        s2.setEffectiveDate("2015-01-01");
        s2.setMid(new BigDecimal("3.232"));
        s2.setNo("a");
        s2.setTable('A');
        s2.setCurrency("AAA");
        s2.setCode("CSS");
        s2.setId(null);

        System.out.println(s1.equals(s2));
    }
}
