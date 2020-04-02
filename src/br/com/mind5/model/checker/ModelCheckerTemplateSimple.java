package br.com.mind5.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.RootSymsgSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ModelCheckerTemplateSimple<T extends InfoRecord> implements ModelChecker<T> {
	protected final boolean SUCCESS = ModelCheckerOption.SUCCESS;
	protected final boolean FAILED = ModelCheckerOption.FAILED;

	private Boolean finalResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	private String codLanguage;
	private SymsgInfo symsgData;
	
	
	
	protected ModelCheckerTemplateSimple(ModelCheckerOption option) {
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
		
		boolean checkResult = checkHook(recordInfo, conn, schemaName);
		finalResult = evaluateResult(checkResult, expectedResult);
		
		if (finalResult == FAILED) 
			symsgData = buildMsg(checkResult, codLanguage, conn, schemaName);
		
		return getResult();
	}
	
	
	
	private String getLanguage(T recordInfo) {
		return recordInfo.codLanguage;
	}
	
	
	
	private boolean evaluateResult(boolean actual, boolean expected) {
		if (actual == expected)
			return SUCCESS;
		
		return FAILED;
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
		SymsgInfo result = readMsgHook();
		
		if (result == null)
			result = readSymsg(option);
		
		return result;
	}
	
	
	
	protected SymsgInfo readMsgHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	private SymsgInfo readSymsg(DeciTreeOption<SymsgInfo> option) {
		ActionStdV1<SymsgInfo> select = new RootSymsgSelect(option).toAction();
		select.executeAction();		
		
		return select.getDecisionResult().getResultset().get(0);
	}
	
	
	
	@Override public boolean getResult() {
		if (finalResult == null) {
			logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		}
		
		return finalResult;
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
	
	
	
	protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {
		//Template method: to be overwritten by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
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
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
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
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
