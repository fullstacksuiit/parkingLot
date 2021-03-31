class Vehicle{
    String registrationNumber;
    String colour;

    public Vehicle(String reg, String colour) {
        this.registrationNumber = reg.toUpperCase();
        this.colour = colour.toUpperCase();
    }

    public String getRegistrationNumber(){
        return this.registrationNumber;
    }

    public String getColour(){
        return this.colour;
    }
}