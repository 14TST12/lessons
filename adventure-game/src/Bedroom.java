public class Bedroom extends Room {

    public Bedroom(String name, String description, boolean isLocked) {
        items.add(new Window("Окно", "Окно с ручкой в дальней стене","Окно закрыто и не открывается"));
        items.add(new Furniture("Тумбочка", "Деревянная тумбочка у кровати", ""));
        items.add(new Furniture("Кровать", "Незаправленная кровать из Икеи",""));
        this.setLocked(isLocked);
        this.setName(name);
        this.setDescription(description);
    }
}
