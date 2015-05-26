import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private StringCalculator calculator;

    @Before
    public void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    public void stringVoidReturnZero() throws Exception{
        String entrada ="";

        int result = calculator.add(entrada);

        assertEquals("La entrada vacia no devuelve 0",result,0);
    }

    @Test
    public void stringOneNumberReturnNumber() throws Exception{
        String entrada ="1";

        int result = calculator.add(entrada);

        assertEquals("no devuelve el numero que entra",result,1);
    }

    @Test
    public void stringTwoNumberReturnSum() throws Exception{
        String entrada ="1,2";

        int result = calculator.add(entrada);

        assertEquals("no devuelve la suma de los numeros",result,3);
    }

    @Test
    public void stringFiveNumberReturnSum() throws Exception{
        String entrada ="1,2,3,4,5";

        int result = calculator.add(entrada);

        assertEquals("no devuelve la suma de los numeros",result,15);
    }

    @Test
     public void stringWithNewLinesBetweenNumberReturnSum() throws Exception{
        String entrada ="1 \n2,3";

        int result = calculator.add(entrada);

        assertEquals("no devuelve la suma de los numeros con nuevas lienas entre los numeros",result,6);
    }

    @Test
    public void stringOneNumberWithNewLinesReturnSum() throws Exception{
        String entrada ="1, \n";

        int result = calculator.add(entrada);

        assertEquals("no devuelve la suma de los numeros con nuevas lienas entre los numeros",result,1);
    }

    @Test
    public void exceptionOneNegativeNumber() throws Exception{
        String entrada ="1,-2";
        String message = "negativos no soportados: -2 ";
        String messageResult = "";

        try{
            int result = calculator.add(entrada);
        }catch (Exception e){
            messageResult = e.getMessage();
        }

        assertEquals("los numeros negativos no dan excepcion",messageResult,message);
    }

    @Test
    public void exceptionNegativeNumbers() throws Exception{
        String entrada ="1,-2,-4,5";
        String message = "negativos no soportados: -2 -4 ";
        String messageResult = "";

        try{
            int result = calculator.add(entrada);
        }catch (Exception e){
            messageResult = e.getMessage();
        }

        assertEquals("los numeros negativos no dan excepcion",messageResult,message);
    }

    @Test
    public void ingnoreHigherNumbersOfThousand() throws Exception{
        String entrada ="2,1001";

        int result = calculator.add(entrada);

        assertEquals("No se ignoran los numeros superiores a 1000",result,2);
    }

    @Test
    public void stringDiferentDelimiter() throws Exception{
        String entrada ="//[***]\n1***2***3";

        int result = calculator.add(entrada);

        assertEquals("no devuelve la suma cambiando el delimitador",result,6);
    }

    @Test
    public void stringMultipleDelimiter() throws Exception{
        String entrada ="//[*][%]\n1*2%3";

        int result = calculator.add(entrada);

        assertEquals("no devuelve la suma con multiples delimitadores",result,6);
    }
}
