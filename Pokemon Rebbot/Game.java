/**
 * This class runs the game.  It communicates with the
 * TUI and the pokemon classes.
 * 
 * Assignment Pokemon Reboot
 * Class: Game
 * Authoer: Joe Urbashich
 * Date: 9/9/15
**/

import java.util.Random;

public class Game {

/**
 * This is the main method that runs through the game algorithm
 * 
 * 
 * 
**/

    public static void main (String[] args) {
        
        TUI myTUI = new TUI();

        myTUI.welcome();
        String nameOne = myTUI.name(1);
        String nameTwo = myTUI.name(2);

      
     
        Pokemon pokemon1 = new Pokemon();
        pokemon1.setStats(nameOne, randNum(100), randNum(100), randNum(20));
        myTUI.readStats(1, pokemon1.name(), pokemon1.tolerance(), pokemon1.speed(), pokemon1.power());
        
        Pokemon pokemon2 = new Pokemon();
        pokemon2.setStats(nameTwo, randNum(100), randNum(100), randNum(20));
        myTUI.readStats(2, pokemon2.name(), pokemon2.tolerance(), pokemon2.speed(), pokemon2.power());
        
        myTUI.battleIntro();
        
        // This while loop is the game turn format.  It will run until one of the pokemon is defeated.
        
        while( pokemon1.tolerance() > 0 && pokemon2.tolerance() > 0) {
        
            String playerOneChoice = myTUI.playerChoice(1);
            String playerTwoChoice = myTUI.playerChoice(2);
        
            if( playerOneChoice.equals("defend") && playerTwoChoice.equals("defend") )
                myTUI.bothDefend();
            if( playerOneChoice.equals("attack") && playerTwoChoice.equals("attack") ) {
                

                
                
                if(randNum(100) <= pokemon1.speed()) {
                    pokemon2.getHit(pokemon1.power());
                    myTUI.gotHit(pokemon1.name(), pokemon2.name(), pokemon1.power(), pokemon2.tolerance());
                }    
                
                if(randNum(100) <= pokemon2.speed()) {
                    pokemon1.getHit(pokemon2.power());
                    myTUI.gotHit(pokemon2.name(), pokemon1.name(), pokemon2.power(), pokemon1.tolerance());   
                }
                    
                myTUI.update( pokemon1.name(), pokemon1.tolerance(), pokemon2.name(), pokemon2.tolerance());
                
            }
            
            if( playerOneChoice.equals("attack") && playerTwoChoice.equals("defend") ) {
                
                int num = randNum(100);
                if(num <= 50)
                    myTUI.nothing();
                else if(num <= 75) {
                    pokemon2.getHit(pokemon1.power() / 4);
                    myTUI.gotHit(pokemon1.name(), pokemon2.name(), pokemon1.power()/4, pokemon2.tolerance());
                }    
                
                else {
                    pokemon1.getHit(pokemon1.power() / 4);
                    myTUI.defend(pokemon1.name(), pokemon2.name(), pokemon1.power()/4, pokemon1.tolerance());  
                }

                myTUI.update( pokemon1.name(), pokemon1.tolerance(), pokemon2.name(), pokemon2.tolerance());            
            }
            
            if( playerOneChoice.equals("defend") && playerTwoChoice.equals("attack") ) {
                
                int num = randNum(100);
                if(num <= 50)
                    myTUI.nothing();
                else if(num <= 75) {
                    pokemon1.getHit(pokemon2.power() / 4);
                    myTUI.gotHit(pokemon2.name(), pokemon1.name(), pokemon2.power()/4, pokemon1.tolerance());
                }  
               else {
                    pokemon2.getHit(pokemon2.power() / 4);
                    myTUI.defend(pokemon2.name(), pokemon1.name(), pokemon2.power()/4, pokemon2.tolerance());  
                }
                myTUI.update( pokemon1.name(), pokemon1.tolerance(), pokemon2.name(), pokemon2.tolerance());
            }
            
       
        }
        
        
        myTUI.endState( pokemon1.name(), pokemon1.tolerance(), pokemon2.name(), pokemon2.tolerance());
        
        
       
    }
    
/**
 * This method generates a random number.
 * 
 * @param num: this sets the upper bound of the random numbers range
 * @return rn: this is the random number
 **/
    
    public static int randNum(int num) {
        
        Random rand = new Random();
        int max = num;
        int rn = rand.nextInt((max - 1) + 1) + 1;
        return rn;
    }
    


    
    
}
