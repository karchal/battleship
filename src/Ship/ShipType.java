public enum ShipType{
     CARRIER(5), CRUISER(4), BATTLESHIP(3), SUBMARINE(3), DESTROYER(2);

     private final int length;

     public int getLength() {
          return length;
     }
}