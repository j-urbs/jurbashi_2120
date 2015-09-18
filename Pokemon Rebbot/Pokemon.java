/**
 * A class that serves as the "pokemon"
 * and hold the individual pokemon's data.
 * 
 * Assignment Pokemon Reboot
 * Class: Pokemon
 * Authoer: Joe Urbashich
 * Date: 9/9/15
**/

public class Pokemon {

// instance variables

    private int tolerance; /*@invariant: tolerance >= 0 && tolerance <= 100*/
    private int speed; /*@invariant: speed >= 0 && speed <= 100*/
    private int power; /*@invariant: power >= 0 && power <= 100*/
    private String name;
  
/**
 * Sets the initial stats for the pokemon
 * @param setName: receives name from TUI
 * @param initialTolerance: random number from the game class
 * @para initialSpeed: random number from the game class
 * @para initialPower: random number from the game class
 * */
    public void setStats( String setName, int initialTolerance, int initialSpeed, int initialPower){
   
        
        name = setName;
        tolerance = initialTolerance;
        speed = initialSpeed;
        power = initialPower;

    }

//query methods

    public int tolerance() {
        
        return tolerance;
    }

    public int speed() {
      
        return speed;
    }
  
  
    public int power() {
    
        return power;
    }
  
    public String name() {

        return name;
    }
  
  
  
    public void getHit( int amountOfHit) {
    
    tolerance = tolerance - amountOfHit;
    
    }
  


}