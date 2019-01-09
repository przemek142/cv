package przemek.portfel.Models.Exceptions;

/**
 * CurrencyGetURLException provides exception for ExchangeRateTool if errors occur during parsing.
 */
public class CurrencyGetURLException extends RuntimeException {

    /**
     * displays exeption
     * @param e parent's exception
     */
   public CurrencyGetURLException(Exception e){
        System.err.println("Coud't get currecy, ");
        System.err.println(e);
    }

}
