public class Key extends Item
        implements Collectible, Useful {

    private final Room unlockingRoom;

    public Key(String name, String description, Room unlockingRoom) {
        super(name, description);
        this.unlockingRoom = unlockingRoom;
    }

    @Override
    public void use() {
        if (super.getDescription().equals("Старинный ключ")) {
            Game.winningTheGame();
        } else {
            System.out.println("Дверь открыта");
        }
    }

    public void useKeyToUnlock(Room roomToCheck) {
        if (roomToCheck == unlockingRoom) {
            use();
            roomToCheck.setLocked(false);
        } else {
            System.out.println("Ничего не произошло. Дверь всё ещё закрыта");
        }
    }
}