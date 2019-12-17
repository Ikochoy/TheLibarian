public class LateRecordsManager {
    private boolean isLate = false;

    public void setLate() {
        isLate = true;
    }

    public void clearLateRecord(){
        isLate = false;
    }

    boolean isLate(){
        return isLate;
    }
}
