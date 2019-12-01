package cen3031team6.Statistics;

/**
 * @author Alex Thieler - The Tournament class is to allow tournaments to be created and access
 * to naming and seting an id to the tournament.
 */
public class Tournament {

    private int id;
    private String name;

    /**
     *
     * @param id
     * @param name
     */
    public Tournament(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
