package br.com.mind5.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.json.JsonBodyParser;
import br.com.mind5.json.standard.JstdBodyParser;
import br.com.mind5.model.common.ModelRequestCheckerOwner;
import br.com.mind5.model.common.ModelRequestCheckerUsername;
import br.com.mind5.model.common.ModelResponseError;
import br.com.mind5.model.common.ModelResponseStandard;
import br.com.mind5.model.common.ModelResponseUnauthorized;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public abstract class ModelTemplate<T extends InfoRecord> implements Model {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private List<T> recordInfos;	
	private Connection conn;
	private String schemaName;
	private List<DeciResult<T>> treeResults;
	private boolean isRequestValid;
	private boolean isError;
	
	
	protected ModelTemplate(String incomingData, HttpServletRequest request, Class<T> tClazz) {	
		try {
			checkArgument(incomingData, request, tClazz);		
		
			recordInfos = parseJsonToList(incomingData, tClazz);		
			isRequestValid = checkRequest(recordInfos, request);		
			initDb(isRequestValid);
			isError = false;
			
		} catch (Exception e) {
			logException(e);
			isError = true;
		}
	}
	
	

	protected ModelTemplate(T recordInfo) {
		try {
			checkArgument(recordInfo);
			
			recordInfos = addToList(recordInfo);
			isRequestValid = true;
			initDb(isRequestValid);	
			isError = false;
			
		} catch (Exception e) {
			isError = true;
		}
	}
	
	
	
	private void initDb(boolean isValid) {
		if (isValid == false)
			return;
		
		conn = getDbConn();
		schemaName = getDbSchema();	
	}
	
	
	
	private Connection getDbConn() {
		return DbConnection.getConnection();
	}
	
	
	
	private String getDbSchema() {
		return DbSchema.getDefaultSchemaName();
	}
	
	
	
	private List<T> addToList(T recordInfo) {
		List<T> results = new ArrayList<>();		
		results.add(makeClone(recordInfo));		
		return results;
	}
	
	
	
	private List<T> parseJsonToList(String incomingData, Class<T> tClazz) {
		JsonBodyParser<T> parser = getJsonParserHook(tClazz);
		return parser.parse(incomingData);
	}
	
	
	
	protected JsonBodyParser<T> getJsonParserHook(Class<T> tClazz) {
		return new JstdBodyParser<T>(tClazz);
	}
	
	
	
	private boolean checkRequest(List<T> records, HttpServletRequest request) {
		boolean result;
		ModelRequestChecker reqChecker;
		
		reqChecker = new ModelRequestCheckerOwner(request);
		result = reqChecker.isValid(records);
		
		if (result == false)
			return false;		
		
		reqChecker = new ModelRequestCheckerUsername(request);
		result = reqChecker.isValid(records);
		
		return result;
	}


	
	@Override public boolean executeRequest() {
		if (isStateValid() == false)
			return RESULT_FAILED;
		
		if (isError == true)
			return RESULT_FAILED;
		
		if (isRequestValid == false)
			return RESULT_FAILED;
		
		if (hasExecuted() == true)
			return RESULT_FAILED;
		
		treeResults = tryToExecuteRequest(recordInfos, conn, schemaName);
		return RESULT_SUCCESS;
	}
	
	
	
	private List<DeciResult<T>> tryToExecuteRequest(List<T> records, Connection dbConn, String dbSchema) {	
		List<DeciResult<T>> allResults = new ArrayList<>();		
		
		try {			
			DeciResult<T> lastResult = null;
			Iterator<T> itr = records.iterator();
			
			
			while (itr.hasNext()) {
				T cursor = itr.next();
				
				DeciTreeOption<T> option = buildOption(cursor, dbConn, dbSchema);
				DeciTree<T> deciTree = getDecisionTreeHook(option);
				deciTree.makeDecision();				
				lastResult = deciTree.getDecisionResult();
				deciTree.close();
				
				allResults.add(lastResult);
				
				if (lastResult.isSuccess() == RESULT_FAILED)
					break;
			}
			
					
			closeTransaction(dbConn, lastResult.isSuccess());			
			return allResults;
			
			
		} catch (Exception e) {
			logException(e);
			
			DeciResult<T> errorResult = new DeciResultError<>();
			allResults.add(errorResult);
			
			closeTransaction(dbConn, RESULT_FAILED);	
			return allResults;
		}
	}
	
	
	
	protected DeciTree<T> getDecisionTreeHook(DeciTreeOption<T> option) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciTreeOption<T> buildOption(T recordInfo, Connection dbConn, String dbSchema) {
		DeciTreeOption<T> treeOption = new DeciTreeOption<>();
		
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo);
		
		treeOption.conn = dbConn;
		treeOption.recordInfos = recordInfos;
		treeOption.schemaName = dbSchema;
		
		return treeOption;
	}
	
	
	
	private void commitWork(Connection dbConn) throws SQLException {
		try {
			dbConn.commit();
		
		} catch (Exception e) {
			logException(e);
			rollback(dbConn);
			throw e;
		}
	}
	
	
	
	private void rollback(Connection dbConn) throws SQLException {
		try {
			dbConn.rollback();
			
		} catch (Exception e) {
			logException(e);
			throw e;
		}
	}

	

	@Override public Response getResponse() {
		if (isStateValid(isError) == false) 
			return buildResponseError();
		
		if(isError == true)
			return buildResponseError();
		
		if(isRequestValid == false)
			return buildResponseUnauthorized();
		
		checkStateExecuted();		
		return buildResponse(treeResults);
	}
	
	
	
	@Override public void close() {
		clear();
	}
	
	
	
	private void closeTransaction(Connection dbConn, boolean isSuccess) {
		try {
			tryToCloseTransaction(dbConn, isSuccess);
			
		} catch (SQLException e) {
			logException(e);
		}
	}
	
	
	
	private void tryToCloseTransaction(Connection dbConn, boolean isSuccess) throws SQLException {
		if (dbConn == null)
			return;
		
		if (dbConn.isClosed())
			return;
		
		if (isSuccess == RESULT_SUCCESS) 
			commitWork(dbConn);
			
		if (isSuccess == RESULT_FAILED) 
			rollback(dbConn);
		
		DbConnection.closeConnection(dbConn);
	}
	
	
	
	private void clear() {
		recordInfos = DefaultValue.list();	
		conn = DefaultValue.object();	
		schemaName = DefaultValue.object();
		treeResults = DefaultValue.object();
		isRequestValid = DefaultValue.boole();
		isError = DefaultValue.boole();
	}
	
	
	
	private Response buildResponseUnauthorized() {
		ModelResponse<T> response = new ModelResponseUnauthorized<>(); 
		return response.build();
	}	
	
	
	
	private Response buildResponseError() {
		ModelResponse<T> response = new ModelResponseError<>(); 
		return response.build();
	}
	
	
	
	private boolean isStateValid(boolean hasError) {
		if (hasError == true)
			return false;
		
		if (isStateValid() == false)
			logExceptionObjectIsClosed();
		
		return isStateValid();
	}
	
	
	
	private boolean isStateValid() {
		if (recordInfos == null)
			return false;
		
		if (recordInfos.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private void logExceptionObjectIsClosed() {
		logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
	}
	
	
	
	private void checkStateExecuted() {
		if (hasExecuted() == false) {
			logException(new IllegalStateException(SystemMessage.NO_RESPONSE));
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		}
	}
	
	
	
	private boolean hasExecuted() {
		if (treeResults == null)
			return false;
		
		if (treeResults.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private Response buildResponse(List<DeciResult<T>> results) {
		ModelResponse<T> modelResponse = getModelResponseHook();
		modelResponse.addTreeResults(results);
		return modelResponse.build();
	}
	
	
	
	protected ModelResponse<T> getModelResponseHook() {
		//Template Method: default behavior
		return new ModelResponseStandard<>();
	}
	
	
	
	private T makeClone(T source) {
		return CloneUtil.cloneRecord(source, this.getClass());
	}
		
	
	
	private void checkArgument(String incomingData, HttpServletRequest request, Class<T> tClazz) {
		if (incomingData == null) {
			logException(new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (request == null) {
			logException(new NullPointerException("request" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("request" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (tClazz == null) {
			logException(new NullPointerException("tClazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("tClazz" + SystemMessage.NULL_ARGUMENT);
		}	
	}
	
	
	
	private void checkArgument(T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
