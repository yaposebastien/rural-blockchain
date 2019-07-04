pragma solidity ^0.5.0;

contract RuralContract {

   //Defining the model of the LandTitle
   struct LandTitle {
       uint id;
       string firstName;
       string lastName;
       int256 geoLatLand;
       int256 geoLongLand;
       uint256 areaLand;
       string city;
       string villageName;
   }

   //Define variables of the contract
   LandTitle[] public landTitles;
   uint public nextId = 1;

    
    //Declare Constructor
    constructor() public {
    }

    //Declare List of the Functions of the contract

    /*
    Event LandTitleEvent to help use the logging facility to create a new landTitle
    */
    event LandTitleRegistrationEvent(uint id, string firstName,
                        string lastName, int256 geoLatLand,
                        int256 geoLongLand, uint256 areaLand,
                        string city, string villageName
    );
    
    /*
    Event DeleteLandTitleEvent to help use the logging facility to delete a landTitle
    */
    event DeleteLandTitleEvent(uint id);

    /*
    Event UpdateLandTitleEvent to help use the logging facility to update a landTitle
    */
    event UpdatedLandTitleOwnerEvent(uint id, string firstName,
                               string lastName

    );
    
    /*
    Function registerLandTitle
    @Param firstName,
    @Param lastName,
    @Param geoLatLand,
    @Param geoLongLand,
    @Param areaLand, 
    @Param city,
    @Param villageName
    */

    //Register your land
    function registerLandTitle(
        string memory firstName,
        string memory lastName,
        int256  geoLatLand,
        int256  geoLongLand,
        uint256 areaLand, 
        string memory city,
        string memory villageName
        ) public { 
            landTitles.push(LandTitle(nextId,firstName,lastName,geoLatLand,geoLongLand,areaLand,city,villageName));
            nextId++;
    } 

    /*
    Function ModifyLandTitleOwner
    @Param id
    @Param newFirstName
    @Param newLastName
    */
    function UpdatedLandTitleOwner(uint id, string memory newFirstName, string memory newLastName) public {
        uint i = search(id);
        landTitles[i].firstName = newFirstName;
        landTitles[i].lastName = newLastName;
        
        emit UpdatedLandTitleOwnerEvent(id, newFirstName, newLastName);
    }

    /*
    Function DeleteLandTitle to delete a land title
    */
    function DeleteLandTitle(uint id) public {
        uint i = search(id);
        delete landTitles[i];
        
        emit DeleteLandTitleEvent(id);

    }

     //Retrieve a specific Land Title saved
    function getLandTitle(uint id) view public returns(uint, string memory,
                                    string memory, int256,
                                    int256, uint256,string memory, string memory ){
        uint i = search(id);
        return (landTitles[i].id , landTitles[i].firstName, landTitles[i].lastName,
                landTitles[i].geoLatLand, landTitles[i].geoLongLand, landTitles[i].areaLand,
                landTitles[i].city, landTitles[i].villageName );
    }

    function search(uint id) view internal returns(uint) {
        for(uint i=0; i < landTitles.length; i++) {
            if(landTitles[i].id == id) {
                return i;
            }
        }
        revert("Land Title ID does not exist");
    }

   

    //Function to return all LandTitles Saved
    function getAllOwners() public view returns (uint, string memory,
                                    string memory, int256, int256, uint256,
                                    string memory, string memory) {
        
        for(uint i=1; i < landTitles.length; i++) {
            return (landTitles[i].id , landTitles[i].firstName, landTitles[i].lastName,
                landTitles[i].geoLatLand, landTitles[i].geoLongLand, landTitles[i].areaLand,
                landTitles[i].city, landTitles[i].villageName );    
        }
    }

}
