pragma solidity ^0.5.0;

contract RuralContract {

   //Defining the model of the LandTitle
   struct LandTitle {
       uint id;
       string ownerFirstName;
       string ownerLastName;
       string city;
   }
    
    mapping(uint => LandTitle) public landTitles;
    uint public landTitlesCount;

    //Declare Constructor
    constructor() public{
        addLandTitle("Nke", "Yapo", "Ande");
    }

    function addLandTitle(string memory _ownerFirstName,string memory _ownerLastName,string memory _city) private {
        landTitlesCount ++;
        landTitles[landTitlesCount] = LandTitle(landTitlesCount, _ownerFirstName, _ownerLastName, _city);
    } 
}