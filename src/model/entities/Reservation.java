package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {
    
    private Integer roomNumber;
    private Date checkIn;
    private Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkout){
        if (!checkOut.after(checkIn)){
                throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public void updateDates(Date checkIn, Date checkOut) {
        
        Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                throw new DomainException("Reservation dates for update must be future dates");
            }
            if (!checkOut.after(checkIn)){
                throw new DomainException("Check-out date must be after check-in date");
            }
            this.checkIn = checkIn;
            this.checkout = checkOut;
    }
    
    @Override
    public String toString() {
        return " Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }

    private static class checkOut {

        private static boolean after(Date checkIn) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public checkOut() {
        }
    }
}
