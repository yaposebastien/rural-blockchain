package com.civruralblockchain.webapp.smartRuralContract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
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
    private static final String BINARY = "60806040526001805534801561001457600080fd5b506114c9806100246000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c806361b8ce8c1161005b57806361b8ce8c1461039f57806374a47de8146103b9578063db70a499146103d6578063f8839f871461061b5761007d565b80630b8d438c146100825780630e7f09a41461026557806316c1274614610397575b600080fd5b61009f6004803603602081101561009857600080fd5b5035610638565b604051808981526020018060200180602001888152602001878152602001868152602001806020018060200185810385528c818151815260200191508051906020019080838360005b838110156101005781810151838201526020016100e8565b50505050905090810190601f16801561012d5780820380516001836020036101000a031916815260200191505b5085810384528b5181528b516020918201918d019080838360005b83811015610160578181015183820152602001610148565b50505050905090810190601f16801561018d5780820380516001836020036101000a031916815260200191505b50858103835287518152875160209182019189019080838360005b838110156101c05781810151838201526020016101a8565b50505050905090810190601f1680156101ed5780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b83811015610220578181015183820152602001610208565b50505050905090810190601f16801561024d5780820380516001836020036101000a031916815260200191505b509c5050505050505050505050505060405180910390f35b6103956004803603606081101561027b57600080fd5b81359190810190604081016020820135600160201b81111561029c57600080fd5b8201836020820111156102ae57600080fd5b803590602001918460018302840111600160201b831117156102cf57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561032157600080fd5b82018360208201111561033357600080fd5b803590602001918460018302840111600160201b8311171561035457600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506108c8945050505050565b005b61009f610a49565b6103a7610dbb565b60408051918252519081900360200190f35b610395600480360360208110156103cf57600080fd5b5035610dc1565b610395600480360360e08110156103ec57600080fd5b810190602081018135600160201b81111561040657600080fd5b82018360208201111561041857600080fd5b803590602001918460018302840111600160201b8311171561043957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561048b57600080fd5b82018360208201111561049d57600080fd5b803590602001918460018302840111600160201b831117156104be57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295843595602086013595604081013595509193509150608081019060600135600160201b81111561052257600080fd5b82018360208201111561053457600080fd5b803590602001918460018302840111600160201b8311171561055557600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156105a757600080fd5b8201836020820111156105b957600080fd5b803590602001918460018302840111600160201b831117156105da57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610e78945050505050565b61009f6004803603602081101561063157600080fd5b5035610fb2565b6000818154811061064557fe5b9060005260206000209060080201600091509050806000015490806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106f75780601f106106cc576101008083540402835291602001916106f7565b820191906000526020600020905b8154815290600101906020018083116106da57829003601f168201915b50505060028085018054604080516020601f60001961010060018716150201909416959095049283018590048502810185019091528181529596959450909250908301828280156107895780601f1061075e57610100808354040283529160200191610789565b820191906000526020600020905b81548152906001019060200180831161076c57829003601f168201915b505050600384015460048501546005860154600687018054604080516020601f6002600019610100600188161502019095169490940493840181900481028201810190925282815298999598949750929550909183018282801561082e5780601f106108035761010080835404028352916020019161082e565b820191906000526020600020905b81548152906001019060200180831161081157829003601f168201915b5050505060078301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156108be5780601f10610893576101008083540402835291602001916108be565b820191906000526020600020905b8154815290600101906020018083116108a157829003601f168201915b5050505050905088565b60006108d384611322565b905082600082815481106108e357fe5b906000526020600020906008020160010190805190602001906109079291906113bb565b50816000828154811061091657fe5b9060005260206000209060080201600201908051906020019061093a9291906113bb565b507fc970570d13f16037dca70fecf1fad90e8b1642f2ae44bd35bfb2f5d679f245ff848484604051808481526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156109a657818101518382015260200161098e565b50505050905090810190601f1680156109d35780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b83811015610a065781810151838201526020016109ee565b50505050905090810190601f168015610a335780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a150505050565b600060608082808083806001600054811015610daf5760008181548110610a6c57fe5b90600052602060002090600802016000015460008281548110610a8b57fe5b906000526020600020906008020160010160008381548110610aa957fe5b906000526020600020906008020160020160008481548110610ac757fe5b90600052602060002090600802016003015460008581548110610ae657fe5b90600052602060002090600802016004015460008681548110610b0557fe5b90600052602060002090600802016005015460008781548110610b2457fe5b906000526020600020906008020160060160008881548110610b4257fe5b9060005260206000209060080201600701868054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610be85780601f10610bbd57610100808354040283529160200191610be8565b820191906000526020600020905b815481529060010190602001808311610bcb57829003601f168201915b5050895460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959c508b945092508401905082828015610c765780601f10610c4b57610100808354040283529160200191610c76565b820191906000526020600020905b815481529060010190602001808311610c5957829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959b5087945092508401905082828015610d045780601f10610cd957610100808354040283529160200191610d04565b820191906000526020600020905b815481529060010190602001808311610ce757829003601f168201915b5050845460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815295975086945092508401905082828015610d925780601f10610d6757610100808354040283529160200191610d92565b820191906000526020600020905b815481529060010190602001808311610d7557829003601f168201915b505050505090509850985098509850985098509850985050610db1565b505b9091929394959697565b60015481565b6000610dcc82611322565b905060008181548110610ddb57fe5b60009182526020822060089091020181815590610dfb6001830182611439565b610e09600283016000611439565b600382016000905560048201600090556005820160009055600682016000610e319190611439565b610e3f600783016000611439565b50506040805183815290517f95b4094671ffaf687b813811774946a8d26cd4c85e8895e0729b5634146e8c589181900360200190a15050565b604080516101008101825260018054825260208083018b81529383018a9052606083018990526080830188905260a0830187905260c0830186905260e0830185905260008054928301808255908052835160089093027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5638101938455945180519195610f2b937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564909101929101906113bb565b5060408201518051610f479160028401916020909101906113bb565b50606082015160038201556080820151600482015560a0820151600582015560c08201518051610f819160068401916020909101906113bb565b5060e08201518051610f9d9160078401916020909101906113bb565b50506001805481019055505050505050505050565b600060608060008060006060806000610fca8a611322565b905060008181548110610fd957fe5b90600052602060002090600802016000015460008281548110610ff857fe5b90600052602060002090600802016001016000838154811061101657fe5b90600052602060002090600802016002016000848154811061103457fe5b9060005260206000209060080201600301546000858154811061105357fe5b9060005260206000209060080201600401546000868154811061107257fe5b9060005260206000209060080201600501546000878154811061109157fe5b9060005260206000209060080201600601600088815481106110af57fe5b9060005260206000209060080201600701868054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111555780601f1061112a57610100808354040283529160200191611155565b820191906000526020600020905b81548152906001019060200180831161113857829003601f168201915b5050895460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959c508b9450925084019050828280156111e35780601f106111b8576101008083540402835291602001916111e3565b820191906000526020600020905b8154815290600101906020018083116111c657829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959b50879450925084019050828280156112715780601f1061124657610100808354040283529160200191611271565b820191906000526020600020905b81548152906001019060200180831161125457829003601f168201915b5050845460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959750869450925084019050828280156112ff5780601f106112d4576101008083540402835291602001916112ff565b820191906000526020600020905b8154815290600101906020018083116112e257829003601f168201915b505050505090509850985098509850985098509850985050919395975091939597565b6000805b60005481101561136557826000828154811061133e57fe5b906000526020600020906008020160000154141561135d5790506113b6565b600101611326565b5060408051600160e51b62461bcd02815260206004820152601c60248201527f4c616e64205469746c6520494420646f6573206e6f7420657869737400000000604482015290519081900360640190fd5b919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106113fc57805160ff1916838001178555611429565b82800160010185558215611429579182015b8281111561142957825182559160200191906001019061140e565b50611435929150611480565b5090565b50805460018160011615610100020316600290046000825580601f1061145f575061147d565b601f01602090049060005260206000209081019061147d9190611480565b50565b61149a91905b808211156114355760008155600101611486565b9056fea165627a7a723058205d9c1677aa66f07d7907ffd58e15b55758bd20c2258aa356576d9260d8005bf40029";

    public static final String FUNC_LANDTITLES = "landTitles";

    public static final String FUNC_UPDATEDLANDTITLEOWNER = "UpdatedLandTitleOwner";

    public static final String FUNC_GETALLOWNERS = "getAllOwners";

    public static final String FUNC_NEXTID = "nextId";

    public static final String FUNC_DELETELANDTITLE = "DeleteLandTitle";

    public static final String FUNC_REGISTERLANDTITLE = "registerLandTitle";

    public static final String FUNC_GETLANDTITLE = "getLandTitle";

    public static final Event LANDTITLEREGISTRATIONEVENT_EVENT = new Event("LandTitleRegistrationEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event DELETELANDTITLEEVENT_EVENT = new Event("DeleteLandTitleEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event UPDATEDLANDTITLEOWNEREVENT_EVENT = new Event("UpdatedLandTitleOwnerEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

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

    public RemoteCall<Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>> landTitles(BigInteger param0) {
        final Function function = new Function(FUNC_LANDTITLES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
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

    public RemoteCall<TransactionReceipt> UpdatedLandTitleOwner(BigInteger id, String newFirstName, String newLastName) {
        final Function function = new Function(
                FUNC_UPDATEDLANDTITLEOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(newFirstName), 
                new org.web3j.abi.datatypes.Utf8String(newLastName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>> getAllOwners() {
        final Function function = new Function(FUNC_GETALLOWNERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
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

    public RemoteCall<BigInteger> nextId() {
        final Function function = new Function(FUNC_NEXTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> DeleteLandTitle(BigInteger id) {
        final Function function = new Function(
                FUNC_DELETELANDTITLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> registerLandTitle(String firstName, String lastName, BigInteger geoLatLand, BigInteger geoLongLand, BigInteger areaLand, String city, String villageName) {
        final Function function = new Function(
                FUNC_REGISTERLANDTITLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstName), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.generated.Int256(geoLatLand), 
                new org.web3j.abi.datatypes.generated.Int256(geoLongLand), 
                new org.web3j.abi.datatypes.generated.Uint256(areaLand), 
                new org.web3j.abi.datatypes.Utf8String(city), 
                new org.web3j.abi.datatypes.Utf8String(villageName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple8<BigInteger, String, String, BigInteger, BigInteger, BigInteger, String, String>> getLandTitle(BigInteger id) {
        final Function function = new Function(FUNC_GETLANDTITLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
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

    public List<LandTitleRegistrationEventEventResponse> getLandTitleRegistrationEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LANDTITLEREGISTRATIONEVENT_EVENT, transactionReceipt);
        ArrayList<LandTitleRegistrationEventEventResponse> responses = new ArrayList<LandTitleRegistrationEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LandTitleRegistrationEventEventResponse typedResponse = new LandTitleRegistrationEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.firstName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.lastName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.geoLatLand = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.geoLongLand = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.areaLand = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.city = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.villageName = (String) eventValues.getNonIndexedValues().get(7).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LandTitleRegistrationEventEventResponse> landTitleRegistrationEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LandTitleRegistrationEventEventResponse>() {
            @Override
            public LandTitleRegistrationEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LANDTITLEREGISTRATIONEVENT_EVENT, log);
                LandTitleRegistrationEventEventResponse typedResponse = new LandTitleRegistrationEventEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.firstName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.lastName = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.geoLatLand = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.geoLongLand = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.areaLand = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.city = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.villageName = (String) eventValues.getNonIndexedValues().get(7).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LandTitleRegistrationEventEventResponse> landTitleRegistrationEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LANDTITLEREGISTRATIONEVENT_EVENT));
        return landTitleRegistrationEventEventFlowable(filter);
    }

    public List<DeleteLandTitleEventEventResponse> getDeleteLandTitleEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DELETELANDTITLEEVENT_EVENT, transactionReceipt);
        ArrayList<DeleteLandTitleEventEventResponse> responses = new ArrayList<DeleteLandTitleEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DeleteLandTitleEventEventResponse typedResponse = new DeleteLandTitleEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DeleteLandTitleEventEventResponse> deleteLandTitleEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DeleteLandTitleEventEventResponse>() {
            @Override
            public DeleteLandTitleEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELETELANDTITLEEVENT_EVENT, log);
                DeleteLandTitleEventEventResponse typedResponse = new DeleteLandTitleEventEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DeleteLandTitleEventEventResponse> deleteLandTitleEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETELANDTITLEEVENT_EVENT));
        return deleteLandTitleEventEventFlowable(filter);
    }

    public List<UpdatedLandTitleOwnerEventEventResponse> getUpdatedLandTitleOwnerEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATEDLANDTITLEOWNEREVENT_EVENT, transactionReceipt);
        ArrayList<UpdatedLandTitleOwnerEventEventResponse> responses = new ArrayList<UpdatedLandTitleOwnerEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdatedLandTitleOwnerEventEventResponse typedResponse = new UpdatedLandTitleOwnerEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.firstName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.lastName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdatedLandTitleOwnerEventEventResponse> updatedLandTitleOwnerEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, UpdatedLandTitleOwnerEventEventResponse>() {
            @Override
            public UpdatedLandTitleOwnerEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATEDLANDTITLEOWNEREVENT_EVENT, log);
                UpdatedLandTitleOwnerEventEventResponse typedResponse = new UpdatedLandTitleOwnerEventEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.firstName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.lastName = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdatedLandTitleOwnerEventEventResponse> updatedLandTitleOwnerEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATEDLANDTITLEOWNEREVENT_EVENT));
        return updatedLandTitleOwnerEventEventFlowable(filter);
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

    public static class LandTitleRegistrationEventEventResponse {
        public Log log;

        public BigInteger id;

        public String firstName;

        public String lastName;

        public BigInteger geoLatLand;

        public BigInteger geoLongLand;

        public BigInteger areaLand;

        public String city;

        public String villageName;
    }

    public static class DeleteLandTitleEventEventResponse {
        public Log log;

        public BigInteger id;
    }

    public static class UpdatedLandTitleOwnerEventEventResponse {
        public Log log;

        public BigInteger id;

        public String firstName;

        public String lastName;
    }
}
