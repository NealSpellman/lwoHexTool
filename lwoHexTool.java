import java.util.Scanner;
/**
 * A simple program to print the hex value for worlds in LEGO Universe.
 * 
 * @NS
 * @5/12/15
 */
public class lwoHexTool
{
    public static void hexArgument()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Get the hex value for a world?");
            
        int choiceHexA = userInput.nextInt();
            
        if (choiceHexA == 1)
        {
            System.out.println("Enter the desired world ID.");
            
            int worldChoice = userInput.nextInt();
            printHex(worldChoice);
        }
        if (choiceHexA == 2)
        {
            System.out.println("You can close the program now.");
        }
    }
    
    public static void printIDs()
    {
        String[] worlds = new String[10];
        worlds[0] = "1000 = Venture Explorer";
        worlds[1] = "1100 = Avant Gardens";
        worlds[2] = "1102 = Avant Gardens: Spider Queen Battle";
        worlds[3] = "1200 = Nimbus Station";
        worlds[4] = "1201 = Pet Cove";
        worlds[5] = "1251 = Nimbus Isle";
        worlds[6] = "1300 = Gnarled Forest"; // this ID was used for testing
        worlds[7] = "1400 = Forbidden Valley";
        worlds[8] = "1600 = Starbase 3001";
        worlds[9] = "1700 = LEGO Club";
        
        for(int i = 0; i < worlds.length; i++)
        {
            System.out.println(worlds[i]);
        }
        System.out.println(""); // spacing
    }
    
    public static void printHex(int worldID)
    {
        String hexValue = Integer.toHexString(worldID); // the vanilla hex of the world ID
        
        // the way that LEGO Universe's packets work rests on the fact each world has an ID
        // this ID is converted to hex and swapped and sent via a world load packet to the client
        // this method will get the actual hex value for the world ID specified by the end user
        if (hexValue.length() == 1)
        {
            String newValue = "000" + hexValue;
            System.out.println("Hex Value:" + newValue);
        }
        
        else if (hexValue.length() == 2)
        {
            String newValue = "00" + hexValue;
            System.out.println("Hex Value:" + newValue);
        }
        
        else if (hexValue.length() == 3)
        {
            String halfA = "0" + hexValue.substring(0, 1);
            //System.out.println(halfA); - for debugging
            String halfB = hexValue.substring(1, 3);
            //System.out.println(halfB); - for debugging
            String newValue = halfB + halfA;
            System.out.println("Hex Value:" + newValue);
        }
        
        else if (hexValue.length() == 4)
        {
            String halfA = hexValue.substring(0, 2);
            String halfB = hexValue.substring(2, 4);
            String newValue = halfB + halfA;
            System.out.println("Hex Value:" + newValue);
        }
    }

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("lwoHexTool - NS - Build 5/12/15");
        System.out.println("Print standard world IDs?");
        int choiceA = userInput.nextInt();
        if (choiceA == 1)
        {
            printIDs();
            
            hexArgument();
        }
        
        if (choiceA == 2)
        {
            hexArgument();
        }
    }
}
