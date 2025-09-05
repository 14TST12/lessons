abstract class Item {
    private String name;
    private final String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
}