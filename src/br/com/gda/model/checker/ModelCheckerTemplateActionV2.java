package br.com.gda.model.checker;

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

public abstract class ModelCheckerTemplateActionV2<T extends InfoRecord> implements ModelChecker<T> {
	private final boolean SUCCESS = ModelCheckerOption.SUCCESS;
	private final boolean FAILED = ModelCheckerOption.FAILED;
	private final boolean NOT_FOUND = ModelCheckerOption.FAILED;
	
	private Boolean finalResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	private String codLanguage;
	private SymsgInfo symsgData;	
	
	
	protected ModelCheckerTemplateActionV2(ModelCheckerOption option) {
		checkArgument(option);
		init(option);
	}
	
	
	
	private void init(ModelCheckerOption option) {
		expectedResult = option.expectedResult;
		conn = option.conn;
		schemaName = option.schemaName;
		symsgData = null;
		codLanguage = DefaultValue.language();
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
		DeciTreeOption<T> option = buildActionOption(recordInfo, dbConn, dbSchema);
		ActionStd<T> action = buildActionHook(option);
		
		DeciResult<T> actionResult = execute(action);			
		return evaluateResult(actionResult);
	}
	
	
	
	private DeciTreeOption<T> buildActionOption(T recordInfo, Connection dbConn, String dbSchema) {
		DeciTreeOption<T> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	protected ActionStd<T> buildActionHook(DeciTreeOption<T> option) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);	
	}
	
	
	
	private DeciResult<T> execute(ActionStd<T> action) {
		 checkArgument(action);
		 
		 action.executeAction();
		 return action.getDecisionResult();
	}
	
	
	
	private boolean evaluateResult(DeciResult<T> result) {	
		if (result.isSuccess() == FAILED &&
			result.getFailCode() == SystemCode.INTERNAL_ERROR) {
			
			logException(new IllegalStateException(SystemMessage.INTERNAL_ERROR));
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
		
		
		if (result.isSuccess() == SUCCESS && result.getResultset().isEmpty())
			return NOT_FOUND;
		
		
		return result.isSuccess();			
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
	
	
	
	private void checkArgument(ModelCheckerOption option) {
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
	}
	
	
	
	private void checkArgument(List<T> recordInfos) {
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
	
	
	
	private void checkArgument(ActionStd<T> action) {
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
