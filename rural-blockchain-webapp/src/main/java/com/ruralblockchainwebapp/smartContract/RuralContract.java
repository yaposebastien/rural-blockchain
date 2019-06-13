package com.ruralblockchainwebapp.smartContract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tuples.generated.Tuple4;
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
    private static final String BINARY = "608060405234801561001057600080fd5b506100c16040518060400160405280600381526020017f4e6b6500000000000000000000000000000000000000000000000000000000008152506040518060400160405280600481526020017f5961706f000000000000000000000000000000000000000000000000000000008152506040518060400160405280600481526020017f416e6465000000000000000000000000000000000000000000000000000000008152506100c660201b60201c565b6101f3565b6001805481018082556040805160808101825282815260208082018881528284018890526060830187905260009485528482529290932081518155915180519194929361011893850192910190610158565b5060408201518051610134916002840191602090910190610158565b5060608201518051610150916003840191602090910190610158565b505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061019957805160ff19168380011785556101c6565b828001600101855582156101c6579182015b828111156101c65782518255916020019190600101906101ab565b506101d29291506101d6565b5090565b6101f091905b808211156101d257600081556001016101dc565b90565b6103b5806102026000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80630b8d438c1461003b5780635ed20098146101a3575b600080fd5b6100586004803603602081101561005157600080fd5b50356101bd565b60405180858152602001806020018060200180602001848103845287818151815260200191508051906020019080838360005b838110156100a357818101518382015260200161008b565b50505050905090810190601f1680156100d05780820380516001836020036101000a031916815260200191505b50848103835286518152865160209182019188019080838360005b838110156101035781810151838201526020016100eb565b50505050905090810190601f1680156101305780820380516001836020036101000a031916815260200191505b50848103825285518152855160209182019187019080838360005b8381101561016357818101518382015260200161014b565b50505050905090810190601f1680156101905780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b6101ab610383565b60408051918252519081900360200190f35b600060208181529181526040908190208054600180830180548551600293821615610100026000190190911692909204601f81018790048702830187019095528482529194929390928301828280156102575780601f1061022c57610100808354040283529160200191610257565b820191906000526020600020905b81548152906001019060200180831161023a57829003601f168201915b50505060028085018054604080516020601f60001961010060018716150201909416959095049283018590048502810185019091528181529596959450909250908301828280156102e95780601f106102be576101008083540402835291602001916102e9565b820191906000526020600020905b8154815290600101906020018083116102cc57829003601f168201915b5050505060038301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156103795780601f1061034e57610100808354040283529160200191610379565b820191906000526020600020905b81548152906001019060200180831161035c57829003601f168201915b5050505050905084565b6001548156fea165627a7a72305820a9d2617af7ee70f220e77d49de56dbecbd14e7a399382a460227d1662ca43c9d0029";

    public static final String FUNC_LANDTITLES = "landTitles";

    public static final String FUNC_LANDTITLESCOUNT = "landTitlesCount";

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

    public RemoteCall<Tuple4<BigInteger, String, String, String>> landTitles(BigInteger param0) {
        final Function function = new Function(FUNC_LANDTITLES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple4<BigInteger, String, String, String>>(
                new Callable<Tuple4<BigInteger, String, String, String>>() {
                    @Override
                    public Tuple4<BigInteger, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> landTitlesCount() {
        final Function function = new Function(FUNC_LANDTITLESCOUNT, 
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
