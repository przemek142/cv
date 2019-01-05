package przemek.portfel.Models.Exceptions;

public class CurrencyGetURLException extends RuntimeException {

   public CurrencyGetURLException(Exception e){
        System.err.println("Coud't get currecy, ");
        System.err.println(e);
    }

}
