import java.util.ArrayList;
import java.util.Scanner;

public class Verwaltung {

    //personenverwaltung erstellen und zu liste hinzufügen
    //listen pv linz, pv cb usw hinzufügen

    //string to string methode zum ausdrucken der liste


    public ArrayList<Personenverwaltung> directorsList = new ArrayList<>();

    public static void main(String[] args) {

        Personenverwaltung cb = new Personenverwaltung("CB");
        Personenverwaltung linz = new Personenverwaltung("Linz");
        Personenverwaltung avengers = new Personenverwaltung("Avengers");

        Personenverwaltung current = null;

        Scanner sc = new Scanner(System.in);
        int select;
        boolean cont = true;

        System.out.println("Herzlich willkommen zur Personenverwaltung");

        do {


            System.out.println("Wöhlen Sie eine Personenverwaltung aus: \n1.) Coders Bay \n2.) Linz \n3.) Avengers");
            System.out.println("0.) Programm beenden");
            select = sc.nextInt();

            /*
            if (select == 1) {
                current = cb;
            } else if (select == 2) {
                current = linz;
            } else  {
                current = avengers;
            }
            */
            
            if (select == 1) {
                current = cb;
            } else if (select == 2) {
                current = linz;
            } else if (select == 3)  {
                current = avengers;
            } else {
                System.out.println("Tschüss.");
                System.exit(0);
            }
            


            System.out.println("1.) Person anlegen \n2.) Person löschen");
            select = sc.nextInt();

            if (select == 1) {
                System.out.println("Welches Informationspaket wollen Sie für die Person anlegen?");
                System.out.println("1.) Simple - Vorname / Nachname");
                System.out.println("2.) Advanced - Vorname / Nachname / Geschlecht / Geburtstag");
                System.out.println("3.) Premium - Vorname / Nachname / Geschlecht / Geburtstag / Straße / Nr / Plz / Stadt");
                select = sc.nextInt();
                sc.nextLine();

                if (select == 1) {
                    System.out.println("Vorname");
                    String FirstName = sc.nextLine();
                    System.out.println("Nachname");
                    String LastName = sc.nextLine();

                    current.createSimplePerson(FirstName, LastName);
                } else if (select == 2) {
                    System.out.println("Vorname");
                    String FirstName = sc.nextLine();
                    System.out.println("Nachname");
                    String LastName = sc.nextLine();
                    System.out.println("Geschlecht (männlich/weiblich/divers)");
                    Gender gender = Gender.valueOf(sc.next());
                    System.out.println("Geburtstag");
                    String BirthDay = sc.nextLine();

                    current.createHigherPerson(FirstName, LastName, gender, BirthDay);
                } else if (select == 3) {
                    System.out.println("Vorname");
                    String FirstName = sc.nextLine();
                    System.out.println("Nachname");
                    String LastName = sc.nextLine();
                    System.out.println("Geschlecht (männlich/weiblich/divers)");
                    Gender gender = Gender.valueOf(sc.next());
                    System.out.println("Geburtstag");
                    String BirthDay = sc.nextLine();
                    System.out.println("Straße");
                    String Street = sc.nextLine();
                    System.out.println("Nr");
                    String Nr = sc.nextLine();
                    System.out.println("Plz");
                    String Plz = sc.nextLine();
                    System.out.println("Stadt");
                    String City = sc.nextLine();

                    current.createFullPerson(FirstName, LastName, gender, BirthDay, Street, Nr, Plz, City);

                }

                //ArrayList<Person> list = current.getPv();
                //for (Person person : list) {
                //    System.out.println(person.getFirstName());
                //}

                for (Person person : current.getPv()) {
                    System.out.println(person.getFirstName());
                }

            } // Auswahl anlegen

            else if (select == 2){
                System.out.println("Sie haben löschen ausgewählt");

                for (int i = 0; i < current.getPv().size(); i++) {
                    System.out.println(i + ".) " + current.getPv().get(i).getFirstName());
                }

                System.out.println("Welche Person möchten Sie löschen?");
                select = sc.nextInt();

                current.getPv().remove(select);

            }

        } while (cont); //main total

    }

    public void createPersonenverwaltung(String name) {

        directorsList.add(new Personenverwaltung(name));
    }

    public String toString() {


        String result = "";

        for (Personenverwaltung pv : directorsList) {
            result += pv.toString();
        }
        return result;
    }

}
