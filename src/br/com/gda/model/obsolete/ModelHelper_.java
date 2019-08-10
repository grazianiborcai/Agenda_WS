package br.com.gda.model.obsolete;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DbConnection;
import br.com.gda.common.SystemMessage;
import br.com.gda.json.obsolete.JsonResponse;
import br.com.gda.json.obsolete.JsonToList;
import br.com.gda.model.Model;
import br.com.gda.model.ModelRequestChecker;
import br.com.gda.model.common.ModelRequestCheckerOwner;
import br.com.gda.model.common.ModelRequestCheckerUsername;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class ModelHelper_<T> implements Model {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private List<T> recordInfos;	
	private Connection conn;
	private String schemaName;
	private Response response;
	private List<DeciResult<T>> treeResults;
	private DeciTreeFactory<T> treeFactory;	
	
	
	public static <T> Model factory(ModelOption_<T> option, String incomingData, HttpServletRequest request) {
		try {
			return new ModelHelper_<T>(option, incomingData, request);
			
		} catch (Exception e) {
			logException(e);
			return new ModelFailed_();
		}
	}
	
	
	
	public static <T> Model factory(ModelOption_<T> option, T recordInfo) {
		try {
			return new ModelHelper_<T>(option, recordInfo);
			
		} catch (Exception e) {
			logException(e);
			return new ModelFailed_();
		}
	}
	
	
	
	private ModelHelper_(ModelOption_<T> option, String incomingData, HttpServletRequest request) {		
		checkArgument(option, incomingData, request);
		List<T> recordInfos = parseRawInfo(incomingData, option.recordClass);
		init(option, recordInfos);	
		checkRequest(recordInfos, request);
	}
	
	

	private ModelHelper_(ModelOption_<T> option, T recordInfo) {
		checkArgument(option, recordInfo);
		init(option, recordInfo);	
	}
	
	
	
	private List<T> parseRawInfo(String rawInfo, Class<T> infoRecordClass) {
		JsonToList<T> parser = new JsonToList<>(infoRecordClass);
		return parser.parse(rawInfo);
	}
	
	
	
	private void init(ModelOption_<T> option, T record) {
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(record);
		
		init(option, recordInfos);
	}
	
	
	
	private void init(ModelOption_<T> option, List<T> records) {
		conn = option.conn;
		schemaName = option.schemaName;
		treeFactory = option.deciTreeFactory;
		recordInfos = records;			
		treeResults = new ArrayList<>();
	}
	
	
	
	@Override public boolean executeRequest() {		
		if (hasResult(treeResults)) 
			return getLastResult().isSuccess();
		
		return tryToExecuteRequest();
	}
	
	
	
	private boolean tryToExecuteRequest() {	
		try {
			DeciResult<T> lastResult = null;
			Iterator<T> itr = recordInfos.iterator();
			
			while (itr.hasNext()) {
				T cursor = itr.next();
				lastResult = execute(cursor);			
				
				if (shouldStop(lastResult))
					break;
			}
			
					
			closeTransaction(lastResult);
			buildResponse(lastResult, treeResults);
			
			return lastResult.isSuccess();
			
		} catch (Exception e) {
			logException(e);
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR);
			return RESULT_FAILED;
		}
	}
	
	
	
	private DeciResult<T> execute(T recordInfo) {
		DeciTree<T> decisionTree = buildDecisionTree(recordInfo);
		DeciResult<T> treeResult = makeDecision(decisionTree);
		addTreeResult(treeResult);	
		
		return getLastResult();
	}
	
	
	
	private DeciTree<T> buildDecisionTree(T recordInfo) {
		DeciTreeOption<T> treeOption = buildOption(recordInfo);
		return treeFactory.getInstance(treeOption);
	}
	
	
	
	private DeciTreeOption<T> buildOption(T recordInfo) {
		DeciTreeOption<T> treeOption = new DeciTreeOption<>();
		
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo);
		
		treeOption.conn = conn;
		treeOption.recordInfos = recordInfos;
		treeOption.schemaName = schemaName;
		
		return treeOption;
	}
	
	
	
	private DeciResult<T> makeDecision(DeciTree<T> tree) {
		tree.makeDecision();
		return tree.getDecisionResult();
	}
	
	
	
	private DeciResult<T> getLastResult() {
		int lasElem = treeResults.size() - 1;		
		return treeResults.get(lasElem);
	}	
	
	
	
	private boolean shouldStop(DeciResult<T> treeResult) {
		return (treeResult.isSuccess() == RESULT_FAILED);
	}
	
	
	
	private void tryToCloseTransaction(DeciResult<T> treeResult) {
		try {
			closeTransaction(treeResult);
			
		} catch (SQLException e) {
			logException(e);
		}
	}
	
	
	
	private void closeTransaction(DeciResult<T> treeResult) throws SQLException {
		if (treeResult.isSuccess() == RESULT_SUCCESS) 
			commitWork();
			
		if (treeResult.isSuccess() == RESULT_FAILED) 
			rollback();
		
		DbConnection.closeConnection(conn);
	}
	
	
	
	private void commitWork() throws SQLException {
		try {
			conn.commit();
		
		} catch (Exception e) {
			logException(e);
			rollback();
			throw e;
		}
	}
	
	
	
	private void rollback() throws SQLException {
		try {
			conn.rollback();
			
		} catch (Exception e) {
			logException(e);
			throw e;
		}
	}
	
	
	
	private void buildResponse(DeciResult<T> lastTreeResult, List<DeciResult<T>> allTreeResults) {		
		if (lastTreeResult.isSuccess() == RESULT_FAILED) 
			makeResponseFailed(lastTreeResult);		
		
		if (lastTreeResult.isSuccess() == RESULT_SUCCESS)
			makeResponseSuccess(allTreeResults);
	}
	
	
	
	private void makeResponseFailed(DeciResult<T> treeResult) {
		Response.Status htmlStatus = Response.Status.BAD_REQUEST;
		
		if (treeResult.getFailCode() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
			htmlStatus = Response.Status.INTERNAL_SERVER_ERROR;
		
		makeResponse(treeResult.getFailMessage(), treeResult.getFailCode(), htmlStatus);
	}
	
	
	
	private void makeResponseSuccess(List<DeciResult<T>> allTreeResults) {
		List<T> allResultsets = new ArrayList<>();
		
		for (DeciResult<T> eachResult : allTreeResults) {
			if (eachResult.hasResultset()) {
				List<T> eachResultset = eachResult.getResultset();
				allResultsets.addAll(eachResultset);
			}
		}
		
		makeResponse(SystemMessage.RETURNED_SUCCESSFULLY, Response.Status.OK.getStatusCode(), Response.Status.OK, allResultsets);
	}
	
	
	
	private void addUnauthorizedResult() {
		Response.Status htmlStatus = Response.Status.UNAUTHORIZED;
		DeciResultHelper<T> resultHelper = new DeciResultHelper<>();
		
		resultHelper.resultset = Collections.emptyList();
		resultHelper.failMessage = htmlStatus.toString();
		resultHelper.failCode = htmlStatus.getStatusCode();
		resultHelper.isSuccess = false;
		resultHelper.hasResultset = false;
		
		addTreeResult(resultHelper);			
		makeResponse(resultHelper.failMessage, resultHelper.failCode, htmlStatus);
	}
	
	
	
	private void addTreeResult(DeciResult<T> treeResult) {
		treeResults.add(treeResult);
	}
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus) {		
		makeResponse(msg, msgCode, htmlStatus, new Object());
	}
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus, Object bodyMsg) {		
		JsonResponse responseMaker = new JsonResponse(msg, msgCode, htmlStatus, bodyMsg);
		response = responseMaker.makeResponse();
	}
	
	
	
	@Override public Response getResponse() {
		checkState(response);		
		return response;
	}
	
	
	
	private void checkState(Response resp) {
		if (hasResponse(resp) == false) {
			logException(new IllegalStateException(SystemMessage.NO_RESPONSE));
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		}
	}
	
	
	
	private boolean hasResponse(Response res) {
		if (res == null)
			return false;
		
		return true;
	}
	
	
	
	private boolean hasResult(List<DeciResult<T>> results) {
		if (results.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private void checkArgument(ModelOption_<T> option, String incomingData, HttpServletRequest request) {
		if (incomingData == null) {
			logException(new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (request == null) {
			logException(new NullPointerException("request" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("request" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		checkOption(option);
	}
	
	
	
	private void checkArgument(ModelOption_<T> option, T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		checkOption(option);
	}
	
	
	
	private void checkOption(ModelOption_<T> option) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordClass == null) {
			logException(new NullPointerException("option.infoRecordClass" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.infoRecordClass" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.deciTreeFactory == null) {
			logException(new NullPointerException("option.decisionTreeFactory" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.decisionTreeFactory" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean checkRequest(List<T> recordInfos, HttpServletRequest request) {
		boolean result = checkRequestOwner(recordInfos, request);
		
		if (result == true)
			result = checkRequestUsername(recordInfos, request);
		
		
		if (result == false) {
			addUnauthorizedResult();
			tryToCloseTransaction(getLastResult());
		}				
		
		return result;
	}
	
	
	
	private boolean checkRequestOwner(List<T> recordInfos, HttpServletRequest request) {
		ModelRequestChecker reqChecker = new ModelRequestCheckerOwner(request);
		return reqChecker.isValid(recordInfos);
	}
	
	
	
	private boolean checkRequestUsername(List<T> recordInfos, HttpServletRequest request) {
		ModelRequestChecker reqChecker = new ModelRequestCheckerUsername(request);
		return reqChecker.isValid(recordInfos);
	}
	
	
	
	private static void logException(Exception e) {
		Logger logger = LogManager.getLogger(ModelHelper_.class);
		logger.error(e.getMessage(), e);
	}
}
