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
    static String[] adressType = {"hus", "tv.", "th."};
    static String[] phoneDescription = {"Hjemme", "Mobil", "Skype", "Arbejde"};
    static String[] hobbyNames = {"Golf", "Svømning", "Fodbold", "Håndbold", "Gaming", "Tennis", "Robotter", "Biler", "Cykler", "Fiskeri", "Løb", "Ski", "Dans"};
    static String[] hobbyDescriptions = {"golf, slå & gå", "blop, blop & blop", "Løb, spark & vind", "Løb, kast & vind", "klik, klik & klik", "Smash, løb & smash", "bip, biiip & biiiip", "Tøf, tøf & VRRRRRRN", "træd, træd & træd", "Kast, vent & træk", "løb, løb & løb", "Frisk luft", "Mit kat den danser tango, tango & tango"};
    static String[] companyName = {"Dell", "Microsoft", "Toshiba", "Packard Bell", "HP", "Lenovo", "Apple", "Acer", "Asus", "Vision"};
    static String[] companyDescription = {"multinational computer technology company", "American multinational technology company", "Japanese multinational conglomerate corporation", "Dutch-based computer manufacturing subsidiary of Acer", "The Hewlett-Packard Company (commonly referred to as HP) was an American multinational information technology company headquartered in Palo Alto, California. It developed and provided a wide variety of hardware components as well as software and related services to consumers, small- and medium-sized businesses (SMBs) and large enterprises, including customers in the government, health and education sectors.\n"
        + "\n"
        + "The company was founded in a one-car garage in Palo Alto by William \"Bill\" Redington Hewlett and David \"Dave\" Packard starting with a line of electronic test equipment. HP was the world's leading PC manufacturer from 2007 to Q2 2013, after which Lenovo remained ranked ahead of HP.[2][3][4] It specialized in developing and manufacturing computing, data storage, and networking hardware, designing software and delivering services. Major product lines included personal computing devices, enterprise and industry standard servers, related storage devices, networking products, software and a diverse range of printers and other imaging products. HP marketed its products to households, small- to medium-sized businesses and enterprises directly as well as via online distribution, consumer-electronics and office-supply retailers, software partners and major technology vendors. HP also had services and consulting business around its products and partner products.", "BLA BLA BLA ", "BLA BLA BLA", "BLA BLA BLA", "BLA BLA BLA", "BLA BLA BLA"};
    static String[] companyCvr = {"18296799", "13612870", "7418600000", "13674671", "28511345", "124151251", "16374573", "135345613", "425634622", "125643164"};
    static int[] companyNumEmployees = {100000,2000000,300000,400000,500000000,6000000,700000000,800000,900000000,1000000000};
    static int[] companyMarketValue = {1234,5678,9012,3456,7890,1234,5678,9012,3456,7890};

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
//Company
    public static String company;

    public static String makeCompany() {
        randomIndex = random.nextInt(companyName.length);
        company = companyName[randomIndex];
        company +="¨"+ companyDescription[randomIndex];
        company +="¨"+ companyCvr[randomIndex];
        company +="¨"+ companyNumEmployees[randomIndex];
        company +="¨"+ companyMarketValue[randomIndex];

        return company;
    }

    public static String makeHobby() {
        randomIndex = random.nextInt(hobbyNames.length);
        hobby = hobbyNames[randomIndex] + "-" + hobbyDescriptions[randomIndex];
        return hobby;
    }

    public static String makePhone() {
        randomIndex = random.nextInt(99999998) + 10000001;
        number = Integer.toString(randomIndex);
        randomIndex = random.nextInt(phoneDescription.length);
        number += "," + phoneDescription[randomIndex];
        return number;
    }

    public static String makeAddInfo() {
        randomIndex = random.nextInt(5) + 1;
        description = Integer.toString(randomIndex) + ". ";
        randomIndex = random.nextInt(adressType.length);
        if (randomIndex == 0) {
            return adressType[0];
        } else {
            description += adressType[randomIndex];
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
