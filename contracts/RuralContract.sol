pragma solidity ^0.5.0;

contract RuralContract {

   //Defining the model of the LandTitle
   struct LandTitle {
       string _code;
       string _ownerFirstName;
       string _ownerLastName;
       uint256 _latLand;
       uint256 _longLand;
       uint256 _areaLand;
       string _city;
       string _villageName;
   }

   //Define variables of the contract
   LandTitle[] public landTitles;
   uint256 public totalOfLandTitles;
   address[16] public registrationAccount;
   
    //mapping(uint => LandTitle) public landTitles;
    
    //Declare Constructor
    constructor() public {
       totalOfLandTitles = 0;
       
    }

    //Declare List of the Functions of the contract

    /*
    Event LandTitleEvent to help use the logging facility to create a new landTitle
    */
    event LandTitleRegistrationEvent(string _code, string _ownerFirstName,
                        string _ownerLastName, uint256 _latLand,
                        uint256 _longLand, uint256 _areaLand,
                        string _city, string _villageName
    );
    
    /*
    Event DeleteLandTitleEvent to help use the logging facility to delete a landTitle
    */
    event DeleteLandTitleEvent(string _code);

    /*
    Event UpdateLandTitleEvent to help use the logging facility to update a landTitle
    */
    event UpdatedLandTitleOwnerEvent(string _code,string _ownerFirstName,
                               string _ownerLastName

    );
    
    /*
    Function registerLandTitle
    @Param _code
    @Param _ownerFirstName,
    @Param _ownerLastName,
    @Param _latLand,
    @Param _longLand,
    @Param _areaLand, 
    @Param _city,
    @Param _villageName
    
    @Return totalOfLandTitles
    */

    //Register your land
    function registerLandTitle(
        string memory _code,
        string memory _ownerFirstName,
        string memory _ownerLastName,
        uint256  _latLand,
        uint256 _longLand,
        uint256 _areaLand, 
        string memory _city,
        string memory _villageName
        ) 
         public returns (uint256 totalOfLandTitles ) {  
             LandTitle memory newLandTitle =  LandTitle(_code,
                        _ownerFirstName, _ownerLastName,
                        _latLand, _longLand, _areaLand,
                        _city, _villageName 
                        );
                
            landTitles.push(newLandTitle);
            totalOfLandTitles++;
            emit LandTitleRegistrationEvent(_code,_ownerFirstName,
                                _ownerLastName, _latLand,
                                _longLand, _areaLand,
                                _city, _villageName
                                );
            return totalOfLandTitles;

    } 

    /*
    Function ModifyLandTitleOwner
    @Param newCode
    @Param newOwnerFirstName
    @Param newOwnerLastName
    */
    function UpdatedLandTitleOwner(string memory newCode, string memory newOwnerFirstName, string memory newOwnerLastName) public returns(bool) {

        for(uint256 i=0; i<totalOfLandTitles; i++) {
            if(compareStrings(landTitles[i]._code, newCode)) {
                landTitles[i]._ownerFirstName = newOwnerFirstName;
                landTitles[i]._ownerLastName = newOwnerLastName;

                emit UpdatedLandTitleOwnerEvent(newCode, newOwnerFirstName, newOwnerLastName);
                return true;
            }  
        }
        return false;
    }

    /*
    Function DeleteLandTitle to delete a land title
    */
    function DeleteLandTitle(string memory _codeDel) public returns (bool isDeleted) {
        require(totalOfLandTitles > 0);

        for(uint256 index=0; index< totalOfLandTitles; index++) {
            if(compareStrings(landTitles[index]._code, _codeDel)) {
                landTitles[index] = landTitles[totalOfLandTitles - 1];
                delete landTitles[totalOfLandTitles - 1];
                totalOfLandTitles--;
                landTitles.length--;

                emit DeleteLandTitleEvent(_codeDel);
                return true;
            }
        }
        return false;
    }

     //Retrieve a specific Land Title saved
    function getLandTitle(string memory _codeRequested) public view returns(
                        string memory _code, string memory _ownerFirstName,
                        string memory _ownerLastName, uint256  _latLand,
                        uint256  _longLand, uint256  _areaLand, 
                        string memory _city, string memory _villageName){

            for(uint256 i = 0; i < totalOfLandTitles; i++) {
                if(compareStrings(landTitles[i]._code, _codeRequested)) {
                    
                    return (
                        landTitles[i]._code, landTitles[i]._ownerFirstName,
                        landTitles[i]._ownerLastName, landTitles[i]._latLand,
                        landTitles[i]._longLand, landTitles[i]._areaLand,
                        landTitles[i]._city, landTitles[i]._villageName
                    );
                }
            }
            revert('This country code was not found');
    } 


    /*
    Function compareStrings to compare the code of the land title given as reference
    */
    function compareStrings (string memory codeA, string memory codeB) internal pure returns(bool) {
        return keccak256(abi.encodePacked(codeA)) == keccak256(abi.encodePacked(codeB));

    }

    //Function to return the number of LandTitles Saved
    function getTotalOfLandTitles() public view returns (uint256 length) {
        return landTitles.length;
    }

}