package com.civruralblockchain.webapp.smartContract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.StaticArray16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class RuralContract extends Contract {
    private static final String BINARY = "6080604052600060105534801561001557600080fd5b506109ec806100256000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c80631a0f76b11461005c57806369b441ac146100955780636a898ba9146100d657806378807e2a1461031d578063d7bce65814610500575b600080fd5b6100796004803603602081101561007257600080fd5b503561051a565b604080516001600160a01b039092168252519081900360200190f35b61009d610537565b604051808261020080838360005b838110156100c35781810151838201526020016100ab565b5050505090500191505060405180910390f35b61031b600480360360e08110156100ec57600080fd5b810190602081018135600160201b81111561010657600080fd5b82018360208201111561011857600080fd5b803590602001918460018302840111600160201b8311171561013957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561018b57600080fd5b82018360208201111561019d57600080fd5b803590602001918460018302840111600160201b831117156101be57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295843595602086013595604081013595509193509150608081019060600135600160201b81111561022257600080fd5b82018360208201111561023457600080fd5b803590602001918460018302840111600160201b8311171561025557600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156102a757600080fd5b8201836020820111156102b957600080fd5b803590602001918460018302840111600160201b831117156102da57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061057e945050505050565b005b61033a6004803603602081101561033357600080fd5b5035610695565b604051808981526020018060200180602001888152602001878152602001868152602001806020018060200185810385528c818151815260200191508051906020019080838360005b8381101561039b578181015183820152602001610383565b50505050905090810190601f1680156103c85780820380516001836020036101000a031916815260200191505b5085810384528b5181528b516020918201918d019080838360005b838110156103fb5781810151838201526020016103e3565b50505050905090810190601f1680156104285780820380516001836020036101000a031916815260200191505b50858103835287518152875160209182019189019080838360005b8381101561045b578181015183820152602001610443565b50505050905090810190601f1680156104885780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b838110156104bb5781810151838201526020016104a3565b50505050905090810190601f1680156104e85780820380516001836020036101000a031916815260200191505b509c5050505050505050505050505060405180910390f35b610508610903565b60408051918252519081900360200190f35b6000816010811061052757fe5b01546001600160a01b0316905081565b61053f610909565b604080516102008101918290529060009060109082845b81546001600160a01b0316815260019091019060200180831161055657505050505090505b90565b3360006010546010811061058e57fe5b0180546001600160a01b0319166001600160a01b0392909216919091179055604080516101008101825260105480825260208083018b81528385018b9052606084018a90526080840189905260a0840188905260c0840187905260e084018690526000928352601182529390912082518155925180519293926106179260018501920190610928565b5060408201518051610633916002840191602090910190610928565b50606082015160038201556080820151600482015560a0820151600582015560c0820151805161066d916006840191602090910190610928565b5060e08201518051610689916007840191602090910190610928565b50505050505050505050565b6011602090815260009182526040918290208054600180830180548651600293821615610100026000190190911692909204601f8101869004860283018601909652858252919492939092908301828280156107325780601f1061070757610100808354040283529160200191610732565b820191906000526020600020905b81548152906001019060200180831161071557829003601f168201915b50505060028085018054604080516020601f60001961010060018716150201909416959095049283018590048502810185019091528181529596959450909250908301828280156107c45780601f10610799576101008083540402835291602001916107c4565b820191906000526020600020905b8154815290600101906020018083116107a757829003601f168201915b505050600384015460048501546005860154600687018054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281529899959894975092955090918301828280156108695780601f1061083e57610100808354040283529160200191610869565b820191906000526020600020905b81548152906001019060200180831161084c57829003601f168201915b5050505060078301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156108f95780601f106108ce576101008083540402835291602001916108f9565b820191906000526020600020905b8154815290600101906020018083116108dc57829003601f168201915b5050505050905088565b60105481565b6040518061020001604052806010906020820280388339509192915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061096957805160ff1916838001178555610996565b82800160010185558215610996579182015b8281111561099657825182559160200191906001019061097b565b506109a29291506109a6565b5090565b61057b91905b808211156109a257600081556001016109ac56fea165627a7a723058203593168e1a83e2ab08f428c6bf27f79748ae68871e087f3363833d7d06b19c350029";

    public static final String FUNC_LANDOWNERS = "landOwners";

    public static final String FUNC_GETLANDOWNERS = "getLandOwners";

    public static final String FUNC_REGISTERLAND = "registerLand";

    public static final String FUNC_LISTOFLANDTITLES = "listOfLandTitles";

    public static final String FUNC_LANDCOUNT = "landCount";

    @Deprecated
    protected RuralContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RuralContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RuralContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RuralContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> landOwners(BigInteger param0) {
        final Function function = new Function(FUNC_LANDOWNERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> getLandOwners() {
        final Function function = new Function(FUNC_GETLANDOWNERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray16<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> registerLand(String _ownerFirstName, String _ownerLastName, BigInteger _latLand, BigInteger _longLand, BigInteger _areaLand, String _city, String _villageName) {
        final Function function = new Function(
                FUNC_REGISTERLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_ownerFirstName), 
                new org.web3j.abi.datatypes.Utf8String(_ownerLastName), 
                new org.web3j.abi.datatypes.generated.Uint256(_latLand), 
                new org.web3j.abi.datatypes.generated.Uint256(_longLand), 
                new org.web3j.abi.datatypes.generated.Uint256(_areaLand), 
                new org.web3j.abi.datatypes.Utf8String(_city), 
                new org.web3j.abi.datatypes.Utf8String(_villageName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>> listOfLandTitles(BigInteger param0) {
        final Function function = new Function(FUNC_LISTOFLANDTITLES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> landCount() {
        final Function function = new Function(FUNC_LANDCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static RuralContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RuralContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RuralContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RuralContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RuralContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RuralContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RuralContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RuralContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RuralContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RuralContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<RuralContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RuralContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RuralContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RuralContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RuralContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RuralContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
