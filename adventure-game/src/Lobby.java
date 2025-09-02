public class Lobby extends Room {

    public Lobby(String name, String description) {
        items.add(new Note("Заметка", "Заметка, прикреплённая к стене", ""));
        this.setLocked(false); // Lobby must be always opened
        this.setName(name);
        this.setDescription(description);
    }
}
