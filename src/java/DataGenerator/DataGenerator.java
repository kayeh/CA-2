package DataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    static String[] lastnames = {"hansen", "jonsen", "olsen", "jonsen", "carlsen", "larsen", "simonsen", "ditlevsen", "graabek", "bohn", "szigethy", "wolff", "morgentailer", "kjærsgaard", "Mayweather", "Boldsen", "McGregor", "Andreasen", "Larsson"};
    static String[] maleNames = {"Alexander", "Alex", "andreas", "adrian", "axel", "august", "ali", "ahmed", "Bo", "bent", "carl", "emil", "eli", "eske", "fin", "finn", "frederik", "gert", "gunner", "Henrik", "henning", "hans", "hans-henrik", "Ingolf", "Jonathan", "Jonas", "Junes", "Jan", "Jarl"};
    static String[] femaleNames = {"Andrea", "Alexandra", "Alex", "Birgitte", "Berit", "britt", "bea", "bente", "Carla", "Caroline", "Caio", "Emilie", "Emilia", "Eli", "Fiola", "Gerda", "gundbrit", "Heidi", "Ida", "Ida-Marie", "Josefine", "Julie", "karoline", "Klaudia", "Leila", "Maj-britt"};
    static String[] vejBegyndelse = {"Sorte", "Hvide", "Grøne,", "Orange", "Gule"};
    static String[] vejMidt = {"Fiol", "Rose", "Kælk", "Sten", "Skovl", "Bjørn", "Sol", "Ræv", "Fasan", "Mose", "Bule"};
    static String[] vejEndelse = {" Alle", "Vej", "Stræde", "Gade", "Torv"};

    static int malesSize = maleNames.length;
    int femaleSize = femaleNames.length;
    static int gender;
    static Random random = new Random();
    static String forename;
    static String lastname;
    static List<String> persons = new ArrayList<>();
    static List<String> streets = new ArrayList<>();

    public static int randomIndex;
    public static int randomLastname;

    public static void makeStreet() {

    }

    public static String makePerson() {

        //Decide Gender by random number
        gender = random.nextInt(2);
        randomLastname = random.nextInt(lastnames.length);

        //Random Male Forename
        if (gender == 0) {
            randomIndex = random.nextInt(malesSize);
            forename = maleNames[randomIndex].substring(0, 1).toUpperCase() + maleNames[randomIndex].substring(1, maleNames[randomIndex].length());
        }
        //Random Female Forename
        if (gender == 1) {
            randomIndex = random.nextInt(femaleNames.length);
            forename = femaleNames[randomIndex].substring(0, 1).toUpperCase() + femaleNames[randomIndex].substring(1, femaleNames[randomIndex].length());
        }

        //Lastname
        lastname = lastnames[randomLastname].substring(0, 1).toUpperCase() + lastnames[randomLastname].substring(1, lastnames[randomLastname].length());

        //put into a list, and then print it    
        if (persons.indexOf(forename) == -1 && persons.indexOf(lastname) == -1) {
            persons.add("INSERT INTO PERSON VALUES (null,'" + forename + "'" + "," + "'" + lastname + "'" + ");");
        }

        return forename +","+ lastname;

    }

}
