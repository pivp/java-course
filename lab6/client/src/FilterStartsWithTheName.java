import java.io.Serializable;
import java.util.ArrayList;

public class FilterStartsWithTheName implements Serializable
{
    private String startingString;
    private ArrayList<Movie> movieArrayList;

    public void setStartingString(String startingString)
    {
        this.startingString = startingString;
    }

    public String getStartingString()
    {
        return this.startingString;
    }

    public void setMovieArrayList(ArrayList<Movie> movieArrayList)
    {
        this.movieArrayList = movieArrayList;
    }

    public void print()
    {
        if (this.movieArrayList.isEmpty())
            System.out.println("There are no movies whose name's starts with " + this.startingString + '.');
        else
            this.movieArrayList.forEach(System.out::println);
    }
}
