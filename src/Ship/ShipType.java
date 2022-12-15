package Ship;

public enum ShipType{
     CARRIER(5), CRUISER(4), BATTLESHIP(3), SUBMARINE(3), DESTROYER(2);

     private final int length;

     ShipType(int length) {
          this.length = length;
     }

     public int getLength() {
          return length;
     }

     @Override
     public String toString(){
          return name() + " of length " + getLength();
     }

     public static void main(String[] args) {
          System.out.println(ShipType.CRUISER.toString());
     }
}