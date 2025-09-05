import java.util.ArrayList;
import java.util.List;

abstract class Room {
    public List<Item> items = new ArrayList<>();

    private String name;
    private String description;
    private boolean isLocked = false;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean lockStatus) {
        isLocked = lockStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // deleted ABSTRACT (that was requested in subtask1) for this method as realization is the same on each child class.
    // It makes more sense to use common defined method in abstract class rather than copy-paste the same code to each child class
    public void printItems() {
        System.out.print("Предметы в комнате " + this.getName() +": ");
        for (int i = 0; i < items.size(); i++) {
            System.out.print(i+1 + ". " + items.get(i).getName());
            if(i<items.size()-1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }
        System.out.println();
    }
}