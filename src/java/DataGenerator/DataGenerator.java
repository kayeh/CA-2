package DataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    
    // Prefix & Affix to generate the random Strings
    static String[] lastnames = {"hansen", "jonsen", "olsen", "jonsen", "carlsen", "larsen", "simonsen", "ditlevsen", "graabek", "bohn", "szigethy", "wolff", "morgentailer", "kjærsgaard", "Mayweather", "Boldsen", "McGregor", "Andreasen", "Larsson"};
    static String[] maleNames = {"Alexander", "Alex", "andreas", "adrian", "axel", "august", "ali", "ahmed", "Bo", "bent", "carl", "emil", "eli", "eske", "finn", "frederik", "gert", "gunner", "Henrik", "henning", "hans", "hans-henrik", "Ingolf", "Jonathan", "Jonas", "Junes", "Jan", "Jarl"};
    static String[] femaleNames = {"Andrea", "Alexandra", "Alex", "Birgitte", "Berit", "britt", "bea", "bente", "Carla", "Caroline", "Caio", "Emilie", "Emilia", "Eli", "Fiola", "Gerda", "gundbrit", "Heidi", "Ida", "Ida-Marie", "Josefine", "Julie", "karoline", "Klaudia", "Leila", "Maj-britt"};
    static String[] streetBegin = {"Sorte", "Hvide", "Grøne", "Orange", "Gule"};
    static String[] streetMid = {"fiol", "rose", "kælk", "sten", "skovl", "bjørn", "sol", "ræv", "fasan", "mose", "bule"};
    static String[] streetEnd = {"s Alle", "vej", "s Stræde", "gade", "s Torv"};
    static String[] estateType = {"hus", "tv.", "th."};
    static String[] phoneDescription = {"Hjemme", "Mobil", "Skype", "Arbejde"};
    static String[] hobbyNames = {"Golf","Svømning","Fodbold","Håndbold","Gaming","Tennis","Robotter","Biler","Cykler","Fiskeri","Løb","Ski","Dans"};
    static String[] hobbyDescriptions = {"golf, slå & gå","blop, blop & blop","Løb, spark & vind","Løb, kast & vind","klik, klik & klik","Smash, løb & smash","bip, biiip & biiiip","Tøf, tøf & VRRRRRRN","træd, træd & træd","Kast, vent & træk","løb, løb & løb","Frisk luft","Mit kat den danser tango, tango & tango"};
    
    //Variables for person
    private static int gender;
    private static Random random = new Random();
    private static String forename;
    private static String lastname;
    private static String description; 
//  private static List<String> persons = new ArrayList<>();
//  private static List<String> streets = new ArrayList<>();

    //Variables for street
    private static int randomIndex;
    private static int randomLastname;
    private static String streetName;
    
    //Variables for Phone
    private static String number;
    
    
    //Variables for Hobby
    private static String hobby;
    
    
    public static String makeHobby(){
        randomIndex = random.nextInt(hobbyNames.length);
        hobby = hobbyNames[randomIndex] +"-" + hobbyDescriptions[randomIndex];
        return hobby;
    }
    
    public static String makePhone(){
        randomIndex = random.nextInt(99999998)+10000001;
        number = Integer.toString(randomIndex);
        randomIndex = random.nextInt(phoneDescription.length);
        number += "," +phoneDescription[randomIndex];
        return number;
    }

    public static String makeAddInfo() {
        randomIndex = random.nextInt(5)+1;
        description = Integer.toString(randomIndex) + ". ";
        randomIndex = random.nextInt(estateType.length);
        if (randomIndex == 0) {
            return estateType[0];
        } else {
            description += estateType[randomIndex];
            return description;
        }

    }

    public static String makeStreet() {
        randomIndex = random.nextInt(streetBegin.length);
        streetName = streetBegin[randomIndex];
        randomIndex = random.nextInt(streetMid.length);
        streetName += streetMid[randomIndex];
        randomIndex = random.nextInt(streetEnd.length);
        streetName += streetEnd[randomIndex];
        randomIndex = random.nextInt(250);

        return streetName + " " + Integer.toString(randomIndex);
    }

    public static String makePerson() {

        //Decide Gender by random number
        gender = random.nextInt(2);
        randomLastname = random.nextInt(lastnames.length);

        //Random Male Forename (with capital first-letter)
        if (gender == 0) {
            randomIndex = random.nextInt(maleNames.length);
            forename = maleNames[randomIndex].substring(0, 1).toUpperCase() + maleNames[randomIndex].substring(1, maleNames[randomIndex].length());
        }
        //Random Female Forename (with capital first-letter)
        if (gender == 1) {
            randomIndex = random.nextInt(femaleNames.length);
            forename = femaleNames[randomIndex].substring(0, 1).toUpperCase() + femaleNames[randomIndex].substring(1, femaleNames[randomIndex].length());
        }

        //Lastname
        lastname = lastnames[randomLastname].substring(0, 1).toUpperCase() + lastnames[randomLastname].substring(1, lastnames[randomLastname].length());

        //put into a list, and then print it    
//        if (persons.indexOf(forename) == -1 && persons.indexOf(lastname) == -1) {
//            persons.add("INSERT INTO PERSON VALUES (null,'" + forename + "'" + "," + "'" + lastname + "'" + ");");
//        }
        return forename + "," + lastname;
        

    }

}
