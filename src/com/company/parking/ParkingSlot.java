package com.company.parking;

public class ParkingSlot {
    private ParkingSlotType type;
    private String id;
    private Car car;

    public ParkingSlot(String id, ParkingSlotType type) throws Exception {
        this.id = validateId(id);
        this. type = type;
    }

    public ParkingSlotType getType() {
        return type;
    }

    public void setType(ParkingSlotType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addCar(Car car) throws Exception {
        ParkingSlotType allowedSlotTypeForCar;
        if(car.isOwnerStaffMember())
            allowedSlotTypeForCar = ParkingSlotType.STAFF;
        else
            allowedSlotTypeForCar = ParkingSlotType.VISITOR;

        if(type == allowedSlotTypeForCar)
            this.car = car;
        else
            throw new Exception("This car is not allowed to park in this slot");
    }

    public void removeCar() throws Exception
    {
        if(car != null)
            car = null;
        else
            throw new Exception("No car parked in this slot");
    }

    public Car parkedCarDetails()
    {
        return car;
    }

    public boolean isOccupied()
    {
        if(car == null)
            return false;
        else
            return true;
    }

    private String validateId(String id) throws Exception {
        boolean validId = false;

        if(id.length() != 3)
            validId = false;
        else if(Character.isUpperCase(id.charAt(0)) && Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2)))
             validId = true;

        if(validId)
            return id;
        else
            throw new Exception("Not a valid id");
    }
}
