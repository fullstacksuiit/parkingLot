class Parking{
    public static void main(String[] args) {
        ParkingLot p = new ParkingLot(5);
        Vehicle v = new Vehicle("OD14X7860", "BLACK");
        p.park(v);
        Vehicle v1 = new Vehicle("OD14X7861", "BLACK");
        p.park(v1);
        p.leave(1);
        Vehicle v3 = new Vehicle("OD14X7862", "BLACK");
        p.park(v3);
        p.displayCarsRegWithColours("BLACK");
        p.searchSlot(v3.getRegistrationNumber());
        p.displaySlotsWithColours("BLACK");
    }
}