import java.time.LocalDate;

public class ReturnDateExtender {
    private boolean isExtended;

    public LocalDate extendReturnDate(LocalDate returnDate){
        if(!isExtended){
            isExtended = true;
            return returnDate.plusDays(7);
        }
        return null;
    }

    public boolean getIsExtended(){
        return isExtended;
    }

}
