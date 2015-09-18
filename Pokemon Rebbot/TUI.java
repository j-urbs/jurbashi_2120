

import java.util.Scanner;

public class TUI {
    
    Scanner input = new Scanner(System.in);
    
    public void welcome() {
        
        System.out.println("\nWelcome to the Pokemon Battle Arena\n");
        
    }
    
    public String name(int num) {
        
        System.out.printf("Player %d, enter the name of your pokemon.\n",num);
        String Pokemon = input.nextLine();
        
        return Pokemon;
        
    }
    
    public String playerChoice(int num) {
        System.out.printf("\nPlayer %d, choose whether to attack or defend. (type attack or defend) \n",num);
        String choice = input.nextLine();
        return choice;
        
    }
    
    public void readStats(int num, String name, int tolerance, int speed, int power) {
        System.out.printf("The name of player %d's pokemon is %s\n", num, name);
        System.out.printf("The tolerance of %s is %d\n", name, tolerance);
        System.out.printf("The speed of %s is %d\n", name, speed);
        System.out.printf("The power of %s is %d\n", name, power);
    }
    
    public void battleIntro() {
        
        System.out.println("\nPrepare yourself!!! \n\nIt is time to battle!!!");
        
    }
    
    public void bothDefend() {
        System.out.println("\nYou both defended... nice... bold strategy there...");
    }
    
    public void error() {
        System.out.println("\nOne of you messed up.  Try again. Only type attack or defend");
    }
    
    public void update(String name1, int tolerance1, String name2, int tolerance2) {
        System.out.printf("\n %s's health is now %d. \n %s's health is now %d ", name1, tolerance1, name2, tolerance2);
        
    }
    
    public void endState(String name1, int tolerance1, String name2, int tolerance2) {

        if(tolerance1 <= 0 && tolerance2 <= 0)
            System.out.printf("\n Both %s and %s were knocked out. Kinda makes you think about the futility of... stuff", name1, name2);
        else if(tolerance1 <= 0)
            System.out.printf("\n %s was knocked out!!! %s Won!!!\n", name1, name2);
        else if(tolerance2 <= 0)
            System.out.printf("\n %s was knocked out!!! %s Won!!!\n", name2, name2);
            

    }
    
    public void nothing() {
        System.out.println("\n Nothing happened... how thrilling...");
    }
    
    public void gotHit(String hitter, String hittee, int damage, int health) {
        System.out.printf("%s successfully attacked %s dealing %d damage.  %s's health is now %d.", hittee, hitter, damage, hitter, health);
        
        
    }
    
    public void defend(String hitter, String hittee, int damage, int health) {
        System.out.printf("%s successfully defended %s dealing %d damage.  %s's health is now %d.", hitter, hittee, damage, hittee, health);
        
        
    }
    


}