public interface ItemInventoryManager {
    int getNoCopies();
    boolean isInStock();
    void decrementCopies();
    void incrementCopies();
}
