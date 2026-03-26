public abstract class Location {
    protected String location_name;
    protected PuzzleStrategy puzzle;

    public Location(String location_name) {
        this.location_name = location_name;
        this.puzzle = PuzzleFactory.creat_puzzel(location_name); //// we create an object from interface and then in the
                                                                 /// constructor we make this
        // object = puzzle factory
    }

    public String get_location_name() {
        return location_name;
    }

    // Each location decides what happens when the player searches
    public abstract void search_into_location(Player player);

    // Each location decides if enemies appear
    public abstract Enemy generateEnemy();
}