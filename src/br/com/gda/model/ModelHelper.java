package br.com.gda.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DbConnection;
import br.com.gda.common.SystemMessage;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.JsonToList;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class ModelHelper<T> implements Model {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private List<T> recordInfos;	
	private Connection conn;
	private String schemaName;
	private Response response;
	private List<DeciResult<T>> treeResults;
	private DeciTreeFactory<T> treeFactory;
	
	
	
	public static <T> Model factory(ModelOption<T> option, String incomingData) {
		try {
			return new ModelHelper<T>(option, incomingData);
			
		} catch (Exception e) {
			logException(e);
			return new ModelFailed();
		}
	}
	
	
	
	public static <T> Model factory(ModelOption<T> option, T recordInfo) {
		try {
			return new ModelHelper<T>(option, recordInfo);
			
		} catch (Exception e) {
			logException(e);
			return new ModelFailed();
		}
	}
	
	
	
	private ModelHelper(ModelOption<T> option, String incomingData) {		
		checkArgument(option, incomingData);
		List<T> recordInfos = parseRawInfo(incomingData, option.infoRecordClass);
		init(option, recordInfos);	
	}
	
	

	private ModelHelper(ModelOption<T> option, T recordInfo) {
		checkArgument(option, recordInfo);
		init(option, recordInfo);	
	}
	
	
	
	private void checkArgument(ModelOption<T> option, String incomingData) {
		if (incomingData == null) {
			logException(new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT);
		}
		
		checkOption(option);
	}
	
	
	
	private void checkArgument(ModelOption<T> option, T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		checkOption(option);
	}
	
	
	
	private void checkOption(ModelOption<T> option) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.infoRecordClass == null) {
			logException(new NullPointerException("option.infoRecordClass" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.infoRecordClass" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.decisionTreeFactory == null) {
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
	
	
	
	private List<T> parseRawInfo(String rawInfo, Class<T> infoRecordClass) {
		JsonToList<T> parser = new JsonToList<>(infoRecordClass);
		return parser.parse(rawInfo);
	}
	
	
	
	private void init(ModelOption<T> option, T record) {
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(record);
		
		init(option, recordInfos);
	}
	
	
	
	private void init(ModelOption<T> option, List<T> records) {
		conn = option.conn;
		schemaName = option.schemaName;
		treeFactory = option.decisionTreeFactory;
		recordInfos = records;			
		treeResults = new ArrayList<>();
	}

	
	
	@Override public boolean executeRequest() {
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
		
		return getLastTreeResult();
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
	
	
	
	private void addTreeResult(DeciResult<T> treeResult) {
		treeResults.add(treeResult);
	}
	
	
	
	private DeciResult<T> getLastTreeResult() {
		int lasElem = treeResults.size() - 1;		
		return treeResults.get(lasElem);
	}	
	
	
	
	private boolean shouldStop(DeciResult<T> treeResult) {
		return (treeResult.isSuccess() == RESULT_FAILED);
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
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus) {		
		makeResponse(msg, msgCode, htmlStatus, new Object());
	}
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus, Object bodyMsg) {		
		JsonResponseMaker responseMaker = new JsonResponseMaker(msg, msgCode, htmlStatus, bodyMsg);
		response = responseMaker.makeResponse();
	}
	
	
	
	public Response getResponse() {
		checkState(response);		
		return response;
	}
	
	
	
	private void checkState(Response state) {
		if (state == null) {
			logException(new IllegalStateException(SystemMessage.NO_RESPONSE));
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		}
	}
	
	
	
	private static void logException(Exception e) {
		Logger logger = LogManager.getLogger(ModelHelper.class);
		logger.error(e.getMessage(), e);
	}
}
