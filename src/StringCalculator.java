import java.util.StringTokenizer;

public class StringCalculator {
    public static final String DELIM_COMA = ",";
    public static final String DELIM_NEW_LINE ="\n";
    public String negativeNumbers ="";

    public int add(String entrada)throws Exception{
        int result = 0;
        if(!entrada.isEmpty()){
            result = sumNumbersString(entrada);
        }
        return result;
    }

    private int sumNumbersString(String entrada) throws Exception{
        int result = 0;
        String delimiter = DELIM_COMA+" "+DELIM_NEW_LINE;
        if(defaultDelimiter(entrada)){
            result = sumNumbers(entrada, delimiter);
        }else{
            delimiter = extractDelimiter(entrada);
            String entradaSinDelimiter = extractNumbers(entrada);
            result = sumNumbers(entradaSinDelimiter, delimiter);
        }

        return result;
    }

    private String extractNumbers(String entrada) {
        StringTokenizer strDelimiters = new StringTokenizer(entrada,DELIM_NEW_LINE);
        String numbers = "";
        strDelimiters.nextToken();
        while(strDelimiters.hasMoreTokens()){
            numbers += strDelimiters.nextToken()+" ";
        }
        return numbers;
    }

    private int sumNumbers(String entrada, String delimiter) throws Exception{
        int result = 0;
        StringTokenizer str = new StringTokenizer(entrada, delimiter);

        while(str.hasMoreTokens()){
            String token = str.nextToken();
            int number = Integer.parseInt(token);
            result = sumNextNumber(result, number);
        }
        checkNegativeNumbers();
        return result;
    }

    private int sumNextNumber(int result, int number) {
        if(isPositiveNumber(number) && isLessOneThousand(number)) {
            result += number;
        }
        return result;
    }

    private boolean isLessOneThousand(int number) {
        return number<1001;
    }

    private boolean isPositiveNumber(int number) {
        boolean isNegative = true;
        if(number<0){
            this.negativeNumbers += number + " ";
            isNegative = false;
        }
        return isNegative;
    }

    private void checkNegativeNumbers() throws Exception{
        String message = "negativos no soportados: " + this.negativeNumbers;
        if(this.negativeNumbers.length()>0){
            throw new Exception(message);
        }
    }

    private String extractDelimiter(String entrada) {
        StringTokenizer str = new StringTokenizer(entrada,DELIM_NEW_LINE);
        String cadenaDelimitadores = str.nextToken();

        StringTokenizer strDelimiters = new StringTokenizer(cadenaDelimitadores.substring(2),"[ ]");
        String delimiters = "";
        while(strDelimiters.hasMoreTokens()){
            delimiters += strDelimiters.nextToken()+" ";
        }
        return delimiters;
    }

    private boolean defaultDelimiter(String entrada) {
        boolean defaultDelimiter = true;

        if(entrada.length()>1){
            String firstCharacters = entrada.substring(0,2);
            if(firstCharacters.equals("//")){
                defaultDelimiter = false;
            }
        }
        return defaultDelimiter;
    }

}
