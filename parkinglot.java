import java.util.HashMap;
import java.util.Map;

class ParkingLot{
    int size;
    boolean[] parkingStatus;
    HashMap<Integer, Vehicle> parkingMap = new HashMap<>();
    HashMap<String, Integer> vehicleregSlotMap = new HashMap<>();
    
    public ParkingLot(int n) {
        this.size = n;
        this.parkingStatus = new boolean[this.size];
    }

    private int searchFreeSpot() {
        boolean[] status = this.parkingStatus;
        for(int i=0; i<status.length; i++){
            if(status[i] == false){
                return i;
            }
        }
        return -1;
    }

    public void park(Vehicle v) {
        int parkingSpot = this.searchFreeSpot();
        if(parkingSpot >= 0){
            this.parkingStatus[parkingSpot] = true; 
            this.parkingMap.put(parkingSpot, v);
            this.vehicleregSlotMap.put(v.getRegistrationNumber(), parkingSpot);
            System.out.println("Allocated slot number: " + (parkingSpot+1));
        }
        else{
            System.out.println("No parking available");
        }
    }

    private Boolean leaveSpot(int index) {
        try {
            this.parkingStatus[index] = false;
            this.parkingMap.remove(index);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    public void leave(int spot) {
        boolean left = this.leaveSpot((spot-1));
        if(left == true){
            System.out.println("Slot number "+ spot + " is free");
        }
        else{
            System.out.println("Wrong slot number");
        }
    }
    public void showCurrentStatus(){
        boolean[] status = this.parkingStatus;
        for(int i = 0; i<status.length; i++){
            System.out.println(status[i]);
        }
    }
    public void searchSlot(String reg) {
        System.out.println((this.vehicleregSlotMap.get(reg.toUpperCase())+1));        
    }
    public void displayCarsRegWithColours(String colour){
        for(Map.Entry element : this.parkingMap.entrySet()){
            Vehicle vehicle = this.parkingMap.get(element.getKey());
            if(vehicle.getColour().equalsIgnoreCase(colour)){
                System.out.println(vehicle.getRegistrationNumber());
            }
        }
    }
    public void displaySlotsWithColours(String colour){
        for(Map.Entry element : this.parkingMap.entrySet()){
            Vehicle vehicle = this.parkingMap.get(element.getKey());
            if(vehicle.getColour().equalsIgnoreCase(colour)){
                System.out.println(((int)element.getKey()+1));
            }
        }
    }
}