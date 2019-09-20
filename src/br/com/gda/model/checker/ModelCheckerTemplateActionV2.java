package br.com.gda.model.checker;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.message.sysMessage.model.decisionTree.RootSymsgSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public abstract class ModelCheckerTemplateActionV2<T extends InfoRecord, S extends InfoRecord> implements ModelChecker<T> {
	private final boolean SUCCESS = ModelCheckerOption.SUCCESS;
	private final boolean FAILED = ModelCheckerOption.FAILED;
	private final boolean NOT_FOUND = ModelCheckerOption.FAILED;
	
	private Boolean finalResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	private String codLanguage;
	private SymsgInfo symsgData;	
	private Class<S> sClazz;
	
	
	protected ModelCheckerTemplateActionV2(ModelCheckerOption option, Class<S> clazz) {
		checkArgument(option, clazz);
		init(option, clazz);
	}
	
	
	
	private void init(ModelCheckerOption option, Class<S> clazz) {
		expectedResult = option.expectedResult;
		conn = option.conn;
		schemaName = option.schemaName;
		symsgData = null;
		codLanguage = DefaultValue.language();
		sClazz = clazz;
	}
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		checkArgument(recordInfos);		
		
		for (T eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult == FAILED)
				return checkerResult;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(T recordInfo) {
		checkArgument(recordInfo);		
		codLanguage = getLanguage(recordInfo);
		
		boolean actionResult = executeAction(recordInfo, conn, schemaName);
		finalResult = hasPassed(actionResult, expectedResult);
		
		if (finalResult == FAILED) 
			symsgData = buildMsg(actionResult, codLanguage, conn, schemaName);
		
		return getResult();
	}
	
	
	
	private String getLanguage(T recordInfo) {
		return recordInfo.codLanguage;
	}
	
	
	
	private boolean executeAction(T recordInfo, Connection dbConn, String dbSchema) {
		DeciTreeOption<S> option = buildActionOption(recordInfo, dbConn, dbSchema);
		ActionStd<S> action = buildActionHook(option);
		
		DeciResult<S> actionResult = execute(action);			
		
		return evaluateResult(actionResult);		
	}
	
	
	
	private DeciTreeOption<S> buildActionOption(T recordInfo, Connection dbConn, String dbSchema) {
		DeciTreeOption<S> option = new DeciTreeOption<>();
		option.recordInfos = toActionClassHook(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	protected ActionStd<S> buildActionHook(DeciTreeOption<S> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	private DeciResult<S> execute(ActionStd<S> action) {
		 checkArgument(action);
		 
		 action.executeAction();
		 return action.getDecisionResult();
	}
	
	
	
	private boolean evaluateResult(DeciResult<S> result) {	
		evaluateResultError(result);			
		
		int maxCount = getMaxCountHook();		
		if (maxCount >= 0)
			return checkRecordCount(result, maxCount);
		
		
		boolean isEmpty = evaluateResultEmpty(result);
		if (isEmpty)
			return NOT_FOUND;
		
		
		return result.isSuccess();			
	}
	
	
	
	private void evaluateResultError(DeciResult<S> result) {
		if (result.isSuccess() 	 == FAILED &&
			result.getFailCode() == SystemCode.INTERNAL_ERROR) {
				
				logException(new IllegalStateException(SystemMessage.INTERNAL_ERROR));
				throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
			}
	}
	
	
	
	private boolean evaluateResultEmpty(DeciResult<S> result) {
		if (result.isSuccess() == SUCCESS && 
			result.getResultset().isEmpty())
				return true;
		
		return false;
	}
	
	
	
	private boolean checkRecordCount(DeciResult<S> result, int maxCount) {
		int count = 0;
		
		if (result.hasResultset())
			count = result.getResultset().size();
		
		return count < maxCount;
	}
	
	
	
	private boolean hasPassed(boolean actual, boolean expected) {
		return (actual == expected);
	}
	
	
	
	@Override public boolean getResult() {
		if (finalResult == null) {
			logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		}
		
		return finalResult;
	}
	
	
	
	private SymsgInfo buildMsg(boolean checkResult, String codLangu, Connection dbConn, String dbSchema) {
		int codMsg = getCodMsg(checkResult);
		SymsgInfo msgToRead = buildMsgToRead(codMsg, codLangu);
		DeciTreeOption<SymsgInfo> option = buildOption(msgToRead, dbConn, dbSchema);
		
		SymsgInfo result = readMsg(option);		
		return result;
	}
	
	
	
	private int getCodMsg(boolean checkResult) {
		if (checkResult == true)
			return getCodMsgOnResultTrueHook();
		
		return getCodMsgOnResultFalseHook();
	}
	
	
	
	private SymsgInfo buildMsgToRead(int codMsg, String codLangu) {
		SymsgInfo symsg = new SymsgInfo();
		symsg.codMsg = codMsg;
		symsg.codLanguage = codLangu;
		
		return symsg;
	}
	
	
	
	private DeciTreeOption<SymsgInfo> buildOption(SymsgInfo symsg, Connection dbConn, String dbSchema) {
		DeciTreeOption<SymsgInfo> option = new DeciTreeOption<>();
		
		option.conn = dbConn;
		option.schemaName = dbSchema;
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(symsg);		
		
		return option;
	}	
	
	
	
	private SymsgInfo readMsg(DeciTreeOption<SymsgInfo> option) {
		ActionStd<SymsgInfo> select = new RootSymsgSelect(option).toAction();
		select.executeAction();		
		
		return select.getDecisionResult().getResultset().get(0);
	}
	
	
	
	protected int getCodMsgOnResultTrueHook() {
		//Template method: default behavior
		return getCodMsgOnResultFalseHook();
	}	
	
	
	
	protected int getCodMsgOnResultFalseHook() {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected int getMaxCountHook() {
		//Template method: default behavior
		return -1;
	}
	
	
	
	protected List<S> toActionClassHook(T recordInfo) {
		//Template method - Default behavior
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo);
		
		return toActionClass(recordInfos);	
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<S> toActionClass(List<T> recordInfos) {
		try {
			S sInstance = sClazz.getConstructor().newInstance();
			
			Method met = sClazz.getMethod("copyFrom", List.class);
			return (List<S>) met.invoke(sInstance, recordInfos);
				
			} catch (Exception e) {
				logException(e);
				throw new IllegalArgumentException(e);
			}
	}
	
	
	
	@Override public String getFailMessage() {
		if (symsgData == null) {
			logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		}
		
		return symsgData.txtMsg;
	}
	
	
	
	@Override public int getFailCode() {
		if (symsgData == null) {
			logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		}
		
		return symsgData.codMsg;
	}
	
	
	
	private void checkArgument(ModelCheckerOption option, Class<S> clazz) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (clazz == null) {
			logException(new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(List<?> recordInfos) {
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		}
	}	
	
	
	
	private void checkArgument(T recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}	
	}	
	
	
	
	private void checkArgument(ActionStd<S> action) {
		if (action == null) {
			logException(new NullPointerException("action" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("action" + SystemMessage.NULL_ARGUMENT);
		}
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
