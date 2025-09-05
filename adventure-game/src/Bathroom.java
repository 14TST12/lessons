public class Bathroom extends Room {

    public Bathroom(String name, String description, boolean isLocked) {
        items.add(new Furniture("Зеркало", "Круглое зеркало над раковиной","Это просто зеркало"));
        items.add(new Furniture("Раковина", "Белая керамическая раковина","Чистая раковина под зеркалом. Больше ничего нет"));
        this.setLocked(isLocked);
        this.setName(name);
        this.setDescription(description);
    }
}