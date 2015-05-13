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
        
        System.out.println("Enter the desired world ID.");
            
        int worldChoice = userInput.nextInt();
        printHex(worldChoice);
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
        
        String space = " ";
        String packetHeader = "53 05 00 02 00 00 00 00 ";
        String packetEnding = " 89 F7 95 51 08 00 5D 04 4F 09 00 00 CD CC CC C1 CD CC E7 43 33 33 39 43 00 00 00 00";
        // packetEnding is the "vanilla" world packet, in that the checksum within is not for all worlds
        // this will need to be changed by the user or ignored if they are using a different generation method
        
        // the way that LEGO Universe's packets work rests on the fact each world has an ID
        // this ID is converted to hex and swapped and sent via a world load packet to the client
        // this method will get the actual hex value for the world ID specified by the end user
        
        // once you get your ID, you need to insert it into the world packet or your code
        if (hexValue.length() == 1)
        {
            String newValue = "0" + hexValue + "00";
            System.out.println("Hex Value: " + newValue);
            System.out.println(packetHeader + newValue + packetEnding);
            
            String newA = newValue.substring(0, 2);
            String newB = newValue.substring(2, 4);
            System.out.println(packetHeader + newA + space + newB + packetEnding);
        }
        
        else if (hexValue.length() == 2)
        {
            String newValue = hexValue + "00";
            System.out.println("Hex Value: " + newValue);
            System.out.println(packetHeader + newValue + packetEnding);
            
            String newA = newValue.substring(0, 2);
            String newB = newValue.substring(2, 4);
            System.out.println(packetHeader + newA + space + newB + packetEnding);
        }
        
        else if (hexValue.length() == 3)
        {
            String halfA = "0" + hexValue.substring(0, 1);
            //System.out.println(halfA); - for debugging
            String halfB = hexValue.substring(1, 3);
            //System.out.println(halfB); - for debugging
            String newValue = halfB + halfA;
            System.out.println("Hex Value: " + newValue);
            
            String newA = newValue.substring(0, 2);
            String newB = newValue.substring(2, 4);
            System.out.println(packetHeader + newA + space + newB + packetEnding);
        }
        
        else if (hexValue.length() == 4)
        {
            String halfA = hexValue.substring(0, 2);
            String halfB = hexValue.substring(2, 4);
            String newValue = halfB + halfA;
            System.out.println("Hex Value: " + newValue);
            
            String newA = newValue.substring(0, 2);
            String newB = newValue.substring(2, 4);
            System.out.println(packetHeader + newA + space + newB + packetEnding);
        }
    }

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("lwoHexTool - NS - Build 5/13/15");
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
