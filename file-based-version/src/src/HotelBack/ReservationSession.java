package HotelBack;

public class ReservationSession 
{
    public static String selectedGuest = null;
    public static String selectedRoom = null;
    public static String selectedReservationID = null;

    public static void clearSession() 
    {
        selectedGuest = null;
        selectedRoom = null;
        selectedReservationID = null;
    }
}
