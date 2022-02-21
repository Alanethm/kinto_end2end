package Utils.generatedTestData;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author King Neg
 */
public class TestData {

    public TestData(){
    }

    /**
     * This method return the actual date with the format dd/MM/yyyy
     * plus a number of days to reach the target date
     *
     * @param numBerOfDaysInTheFuture number of days to add to the actual date
     * @return date in the future
     */
    public String getFutureDate(int numBerOfDaysInTheFuture) {
        Calendar calendar =  Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, numBerOfDaysInTheFuture);
        DateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
        return formatter.format(calendar.getTime());
    }

    /**
     * return the date of today with the format dd/MM/yyyy
     *
     * @return the date of today
     */
    public String getActualDate() {
        Calendar calendar =  Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 0);
        DateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
        return formatter.format(calendar.getTime());
    }

    /**
     * return a random Alpha numeric invoice digit in Uppercase
     *
     * @param length invoice digit length
     * @return random invoice as String
     * @see RandomStringUtils
     */
    public  String getInvoiceNumber(int length) {
        return RandomStringUtils.randomAlphanumeric(length).toUpperCase();
    }

    /**
     * return a random Licence number with the pattern
     * 2 Alphabetic + 3 Numeric + 2 Alphabetic
     * for Italy
     *
     * @return the random Licence number as String
     * @see RandomStringUtils
     */
    public static String getLicenceNumberITALY() {
        String alpha1 = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        String numeric = RandomStringUtils.randomNumeric(3).toUpperCase();
        String alpha2 = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        return alpha1+numeric+alpha2;
    }

    /**
     * return a random Licence number with the pattern
     * 2 Alphabetic + 3 Numeric + 2 Alphabetic
     * for france
     *
     * @return the random Licence number as String
     * @see RandomStringUtils
     */
    public static String getLicenceNumberFrance() {
        String alpha1 = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        String numeric = RandomStringUtils.randomNumeric(3).toUpperCase();
        String alpha2 = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        return alpha1+"-"+numeric+"-"+alpha2;
    }

    /**
     *
     * return <p>a random distance whose length is the number of characters
     * specified.</p>
     * @param count the length of random string to create
     *
     * @return the random distance as string
     */
    public  static String getDistance(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public String getNameWithNumeric(String name){
        Calendar calendar =  Calendar.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(RandomStringUtils.randomAlphabetic(2).toUpperCase());
        stringBuilder.append(calendar.get(Calendar.MINUTE));
        stringBuilder.append(calendar.get(Calendar.MILLISECOND));
        return stringBuilder.toString();
    }

    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }

    public static void main(String[] args) {

        TestData testData = new TestData();
        int days = 5;
        System.out.println("Date of Today");
        System.out.println(testData.getActualDate());
        System.out.println();
        System.out.println("Date of Today + " + days);
        System.out.println(testData.getFutureDate(days));
        System.out.println();
        System.out.println("Invoice Number");
        System.out.println(testData.getInvoiceNumber(8));
        System.out.println();
        System.out.println("Licence Number");
        System.out.println(testData.getLicenceNumberITALY());
        System.out.println();
        System.out.println("Random vehicle VIN");
        System.out.println(VinGeneratorUtils.getRandomVin());
        System.out.println();
        System.out.println("Random name with numeric");
        System.out.println(testData.getNameWithNumeric("Testaumation"));

        String s = "à,â,ô";

        String s1 = s.replaceAll("à", "\u00e0");
        s.replaceAll("[â]","\u00e2");
        s.replaceAll("Ô","o");

        System.out.println("\u00e0");
        // output : E,E,E,E,U,U,I,I,A,A,O,e,e,e,e,u,u,i,i,a,a,o
    }
}
