pragma solidity ^0.5.0;

contract RuralContract {

    address[16] public landOwners;
    uint256 public landCount = 0;
    mapping(uint256 => LandTitle) public listOfLandTitles;

   //Defining the model of the LandTitle
   struct LandTitle {
       uint _id;
       string _ownerFirstName;
       string _ownerLastName;
       uint256 _latLand;
       uint256 _longLand;
       uint256 _areaLand;
       string _city;
       string _villageName;
   }
    
    //Declare Constructor
    constructor() public {
    }

    //Register your land

    function registerLand(
        string memory _ownerFirstName,
        string memory _ownerLastName,
        uint256  _latLand,
        uint256  _longLand,
        uint256  _areaLand, 
        string memory _city,
        string memory _villageName
        ) 
         public {
                    landOwners[landCount] =  msg.sender;
                    listOfLandTitles[landCount] = LandTitle(
                        landCount,
                         _ownerFirstName,
                         _ownerLastName,
                         _latLand,
                         _longLand,
                         _areaLand,
                         _city,
                         _villageName
                         );
    } 

    //Retrieve the list of land owners
    function getLandOwners() public view returns (address[16] memory) {
        return landOwners;
    }
}