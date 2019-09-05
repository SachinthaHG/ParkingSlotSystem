package com.company.parking;

public class Car {
    private String rego;
    private String owner;
    private boolean isOwnerStaffMember;

    public Car(String rego, String owner, boolean isOwnerStaffMember) throws Exception {
        this.rego = validateRego(rego);
        this.owner = owner;
        this.isOwnerStaffMember = isOwnerStaffMember;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isOwnerStaffMember() {
        return isOwnerStaffMember;
    }

    public void setOwnerStaffMember(boolean ownerStaffMember) {
        isOwnerStaffMember = ownerStaffMember;
    }

    private String validateRego(String rego) throws Exception {
        boolean validRego = false;

        if(rego.length() != 5)
            validRego = false;
        else if(Character.isUpperCase(rego.charAt(0)) && Character.isDigit(rego.charAt(1)) && Character.isDigit(rego.charAt(2)) && Character.isDigit(rego.charAt(3)) && Character.isDigit(rego.charAt(4)))
            validRego = true;

        if(validRego)
            return rego;
        else
            throw new Exception("Not a valid rego");
    }
}
