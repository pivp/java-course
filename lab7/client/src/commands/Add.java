package commands;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import data.*;

/**
 * @author Denis Kirbaba
 * @version 2.3
 * Class representing the command to add an object to the collection.
 * Gets the arguments of the added object from the input stream from the client (both from the console and from a file).
 * Stores the arguments of the added object to pass them to the server manager.
 */

public class Add implements Serializable
{
    private String name;
    private Coordinates coordinates;
    private String creationDate;
    private long oscarsCount;
    private Integer goldenPalmCount;
    private MovieGenre genre;
    private MpaaRating mpaaRating;
    private Person screenwriter;
    private String user;

    public Add(String user)
    {
        this.name = this.getFromInputName();
        this.coordinates = new Coordinates(this.getFromInputX(), this.getFromInputY());
        LocalDateTime time = LocalDateTime.now();
        this.creationDate = String.valueOf(time.getHour()) + ':' + time.getHour() + ' ' + time.getDayOfMonth() + '.' +
                time.getMonthValue() + '.' + time.getYear();
        this.oscarsCount = this.getFromInputOscarsCount();
        this.goldenPalmCount = this.getFromInputGoldenPalmCount();
        this.genre = this.getFromInputGenre();
        this.mpaaRating = this.getFromInputMpaaRating();
        this.screenwriter = new Person(this.getFromInputScreenwriterName(), this.getFromInputScreenwriterHeight(),
                this.getFromInputScreenwriterWeight());
        this.user = user;
    }

    public Add(String user, String args[])
    {
        this.name = args[0];
        this.coordinates = new Coordinates(Long.valueOf(args[1]), Long.parseLong(args[2]));
        LocalDateTime time = LocalDateTime.now();
        this.creationDate = String.valueOf(time.getHour()) + ':' + time.getHour() + ' ' + time.getDayOfMonth() + '.' +
                time.getMonthValue() + '.' + time.getYear();
        this.oscarsCount = Long.parseLong(args[3]);
        this.goldenPalmCount = Integer.valueOf(args[4]);
        this.genre = MovieGenre.stringToGenre(args[5]);
        this.mpaaRating = MpaaRating.stringToMpaaRating(args[6]);
        this.screenwriter = new Person(args[7], Integer.parseInt(args[8]), Float.parseFloat(args[9]));
        this.user = user;
    }

    public String getFromInputName()
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name: ");
                String name = scanner.nextLine().trim();
                if (name.equals(""))
                {
                    System.out.println("This value cannot be empty.");
                    continue;
                }
                return name;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be string.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    public long getFromInputOscarsCount()
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter number of oscars: ");
                long oscars = scanner.nextLong();
                if (oscars < 1)
                {
                    System.out.println("Value should be > 0.");
                    continue;
                }
                return oscars;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be integer.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    public Integer getFromInputGoldenPalmCount()
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter number of golden palms: ");
                Integer goldenpalms = scanner.nextInt();
                if (goldenpalms < 1)
                {
                    System.out.println("Value should be > 0.");
                    continue;
                }
                return goldenpalms;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be integer.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    public MovieGenre getFromInputGenre()
    {
        while (true)
        {
            try {
                System.out.println("Movie genres: western, comedy, musical, adventure, thriller.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter genre: ");
                String category = scanner.nextLine().toUpperCase();
                switch (category)
                {
                    case "WESTERN":
                        return MovieGenre.WESTERN;
                    case "COMEDY":
                        return MovieGenre.COMEDY;
                    case "MUSICAL":
                        return MovieGenre.MUSICAL;
                    case "ADVENTURE":
                        return MovieGenre.ADVENTURE;
                    case "THRILLER":
                        return MovieGenre.THRILLER;
                    default:
                        break;
                }
                System.out.println("You should to enter western, comedy, musical, adventure, thriller.");
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be a words (western, comedy, musical, adventure, thriller).");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    public MpaaRating getFromInputMpaaRating()
    {
        while (true)
        {
            try {
                System.out.println("MPAA ratings: G, PG, PG_13, R.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter MPAA rating: ");
                String category = scanner.nextLine().toUpperCase();
                switch (category)
                {
                    case "G":
                        return MpaaRating.G;
                    case "PG":
                        return MpaaRating.PG;
                    case "PG_13":
                        return MpaaRating.PG_13;
                    case "R":
                        return MpaaRating.R;
                    default:
                        break;
                }
                System.out.println("You should to enter G, PG, PG_13, R.");
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be a words (G, PG, PG_13, R).");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    public String getFromInputScreenwriterName()
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter screenwriter name: ");
                String name = scanner.nextLine();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty.");
                    continue;
                }
                return name;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be string.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public int getFromInputScreenwriterHeight()
    {
        while (true)
        {
            try
            {
                System.out.print("Enter screenwriter height: ");
                Scanner scanner = new Scanner(System.in);
                int height = scanner.nextInt();
                if (height <= 0) {
                    System.out.println("This value must be greater than 0.");
                    continue;
                }
                return height;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be integer.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public float getFromInputScreenwriterWeight()
    {
        while (true)
        {
            try
            {
                System.out.print("Enter screenwriter weight: ");
                Scanner scanner = new Scanner(System.in);
                float weight = scanner.nextFloat();
                if (weight <= 0)
                {
                    System.out.println("This value must be greater than 0.");
                    continue;
                }
                return weight;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be float.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public Long getFromInputX()
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter X coordinate (max value is 414): ");
                Long x = scanner.nextLong();
                if (x > 414){
                    System.out.println("Max value is 414.");
                    continue;
                }
                return x;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be integer.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    public long getFromInputY()
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Y coordinate (max value is 211): ");
                long y = scanner.nextInt();
                if (y > 211)
                {
                    System.out.println("Max value is 211.");
                    continue;
                }
                return y;
            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("This value must be integer.");
            }
            catch (NoSuchElementException noSuchElementException)
            {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    public String getName()
    {
        return this.name;
    }

    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }

    public String getCreationDate()
    {
        return this.creationDate;
    }

    public long getOscarsCount()
    {
        return this.oscarsCount;
    }

    public Integer getGoldenPalmCount()
    {
        return this.goldenPalmCount;
    }

    public MovieGenre getGenre()
    {
        return this.genre;
    }

    public MpaaRating getMpaaRating()
    {
        return this.mpaaRating;
    }

    public Person getScreenwriter()
    {
        return this.screenwriter;
    }

    public String getUser()
    {
        return this.user;
    }
}