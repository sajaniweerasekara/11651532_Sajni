/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hasith hettiarachchi
 */
public class TESTCLZ {
    
    
    public static void main(String[] args) 
    {
        //Mock objects
        Guest guest = new Guest("saj", "nunawading", 111);
        Room room = new Room(101, RoomType. SINGLE);
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 1, 111);
        Booking booking = new Booking(guest, room,new Date() , 10, 1, creditCard);
        Hotel hotel = new Hotel();
        
        //Invoking testServiceChargeOrigin method to test addServiceCharge method in Booking class
        //testServiceChargeOrigin(booking);
        //Invoking testServiceChargeOrigin method to test addServiceCharge method in Booking class
        testCheckedOutRecordService( booking,hotel);
        
        
    }
    //Since getCharges method always returns 0 total of service charge is zero-#bug
     public static void testServiceChargeOrigin(Booking booking) 
    {
        double costOne=100;
        double actualTotal=  costOne;
       
        booking.checkIn();
        System.out.println("Checked in");
        System.out.println("Testing addServiceCharge method");
        booking.addServiceCharge(ServiceType.BAR_FRIDGE,  costOne);
        double total = 0;
        //Bug spotted in booking.getCharges method
	List<ServiceCharge> charges = booking.getCharges();
        for (ServiceCharge sc : charges) 
        {
            total += sc.getCost();
							
        }
        if(total==actualTotal)
        {
            System.out.println("OK");
        }
        else
        {
            System.out.println("failed");
        }
        
    }
     public static void testCheckedOutRecordService( Booking booking, Hotel hotel) {
         
         booking.checkIn(); 
         booking.checkOut();
         System.out.println("New Service..........");  
         booking.addServiceCharge(ServiceType.BAR_FRIDGE, 100);
         
        }
    
}
