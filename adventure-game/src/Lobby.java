public class Lobby extends Room {

    public Lobby(String name, String description) {
        items.add(new Window("Окно", "Маленькое окно","Окно закрыто и не открывается"));
        items.add(new Furniture("Шкаф", "Шкаф у стены", "Сбоку шкафа есть надпись: \'Записки помогут понять\'"));
        items.add(new Note("Заметка", "Заметка, прикреплённая к стене коридора", "Старинный ключ! Старинный ключ! Старинный ключ!"));
        this.setLocked(false); // Lobby must be always opened
        this.setName(name);
        this.setDescription(description);
    }
}