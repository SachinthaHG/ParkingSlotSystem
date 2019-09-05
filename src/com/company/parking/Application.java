package com.company.parking;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        CarPark carPark = new CarPark();

        try
        {
            ParkingSlot slotOne = new ParkingSlot("D0", ParkingSlotType.VISITOR);
            carPark.addParkingSlot(slotOne);
            ParkingSlot slotTwo = new ParkingSlot("D02", ParkingSlotType.STAFF);
            carPark.addParkingSlot(slotTwo);

            carPark.deleteParkingSlot("D01");
            ParkingSlot slot = carPark.findParkingSlot("D02");
            List<ParkingSlot> slots = carPark.listAllParkingSlots();

            Car car = new Car("T1234", "Sachintha", true);
            slot.addCar(car);
            Car parkedCar = slot.parkedCarDetails();
            boolean isSlotOccupied;
            isSlotOccupied = slot.isOccupied();
            slot.removeCar();
            isSlotOccupied = slot.isOccupied();
            System.out.println("Done!");
        }
        catch (Exception ex)
        {
            //When your write the Application class use different try catch to handle each exception. I have used one try catch for make it simple.
            ex.printStackTrace();
        }

    }
}
