#include <iostream>
#include <string>
#include <fstream>
#include <iomanip> // for hex
#include <sstream> // for streams

using namespace std;

// C++ Version of lwoHexTool by NS
// Original Java Version: https://github.com/NealSpellman/lwoHexTool/

void printHex(string worldID)
{
	// Prereqs / base packet for use
	string packetHeader = "53 05 00 02 00 00 00 00 ";
	string packetEnding = " 89 F7 95 51 08 00 5D 04 4F 09 00 00 CD CC CC C1 CD CC E7 43 33 33 39 43 00 00 00 00";
	// Now we correct the input from the user
	// if length = 1
	if (worldID.length() == 1)
	{
		string fullID = "0" + worldID + "00";
		cout << "Modified Hex Value: " << fullID << endl;
		// While this does not change for length being 1 or 2, the rest do.
		string partA = fullID.substr(0, 2);
		string partB = fullID.substr(2, 4);
		cout << "Packet: " << packetHeader << partA << " " << partB << packetEnding << endl;
	}
	// if length = 2
	if (worldID.length() == 2)
	{
		string fullID = worldID + "00";
		cout << "Modified Hex Value: " << fullID << endl;

		string partA = fullID.substr(0, 2);
		string partB = fullID.substr(2, 4);
		cout << "Packet: " << packetHeader << partA << " " << partB << packetEnding << endl;
	}
	// if length = 3
	if (worldID.length() == 3)
	{
		string halfA = "0" + worldID.substr(0, 1);
		string halfB = worldID.substr(1, 3);
		string fullID = halfB + halfA;
		cout << "Modified Hex Value: " << fullID << endl;

		string partA = fullID.substr(0, 2);
		string partB = fullID.substr(2, 4);
		cout << "Packet: " << packetHeader << partA << " " << partB << packetEnding << endl;
	}
	// if length = 4
	if (worldID.length() == 4)
	{
		string halfA = worldID.substr(0, 2);
		string halfB = worldID.substr(2, 4);
		string fullID = halfB + halfA;
		cout << "Modified Hex Value: " << fullID << endl;

		string partA = fullID.substr(0, 2);
		string partB = fullID.substr(2, 4);
		cout << "Packet: " << packetHeader << partA << " " << partB << packetEnding << endl;
	}
}

int main()
{
	int userInput;
	cout << "Input the world ID you'd like to convert to hex." << endl;
	cin >> userInput;
	//cout << "In hex: " << hex << userInput << endl;
	stringstream stream;
	stream << hex << userInput;
	string worldID(stream.str());
	cout << "Base Hex Value: " << worldID << endl;
	printHex(worldID);
	
	int done;
	cin >> done;
}