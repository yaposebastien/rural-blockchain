const RuralContract = artifacts.require("./RuralContract.sol");

module.exports = function(deployer) {
  deployer.deploy(RuralContract);
};