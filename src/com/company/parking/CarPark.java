package com.company.parking;

import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private List<ParkingSlot> parkingSlotList = new ArrayList<ParkingSlot>();

    public void addParkingSlot(ParkingSlot parkingSlot) throws Exception {
        parkingSlotList.add(validateNewParkingSlot(parkingSlot));
    }

    public void deleteParkingSlot(String id)
    {
        parkingSlotList.removeIf(parkingSlot -> parkingSlot.getId().equals(id));
    }

    public ParkingSlot findParkingSlot(String id)
    {
        ParkingSlot parkingSlot =  parkingSlotList.stream().filter(slot -> slot.getId().equals(id)).findAny().orElse(null);
        return parkingSlot;
    }

    public List<ParkingSlot> listAllParkingSlots()
    {
        return parkingSlotList;
    }

    private ParkingSlot validateNewParkingSlot(ParkingSlot parkingSlot) throws Exception {
        ParkingSlot slot = findParkingSlot(parkingSlot.getId());

        if(slot == null)
            return parkingSlot;
        else
            throw new Exception("Parking slot already added");
    }
}
