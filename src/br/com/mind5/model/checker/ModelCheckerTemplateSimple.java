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
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ModelCheckerTemplateSimple<T extends InfoRecord> implements ModelChecker<T> {
	private final int STATE_INIT = 0;
	private final int STATE_CLOSED = 1;
	private final int STATE_EXECUTED = 2;
	
	protected final boolean SUCCESS = ModelCheckerOption.SUCCESS;
	protected final boolean FAILED = ModelCheckerOption.FAILED;

	private boolean finalResult;
	private boolean expectedResult;
	private Connection conn;
	private String schemaName;
	private SymsgInfo symsgData;
	private int state;
	
	
	
	protected ModelCheckerTemplateSimple(ModelCheckerOption option) {
		checkArgument(option);
		init(option);
	} 
	
	
	
	private void init(ModelCheckerOption option) {
		expectedResult = option.expectedResult;
		conn = option.conn;
		schemaName = option.schemaName;
		symsgData = null;
		finalResult = true;
		state = STATE_INIT;
	} 	
	
	
	
	@Override public boolean check(List<T> recordInfos) {
		checkState();
		checkArgument(recordInfos);				
		
		for (T eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult == FAILED)
				return checkerResult;
		}
		
		return SUCCESS;
	}
	
	
	
	@Override public boolean check(T recordInfo) {
		checkState();
		checkArgument(recordInfo);				
		
		boolean checkResult = checkHook(recordInfo, conn, schemaName);
		boolean evaluResult = evaluateResult(checkResult, expectedResult);
		setFinalResult(evaluResult);		
		
		symsgData = buildMsg(evaluResult, checkResult, recordInfo, conn, schemaName);
		
		return getResult();
	}
	
	
	
	private void setFinalResult(boolean result) {
		finalResult = result;
		state = STATE_EXECUTED;
	}
	
	
	
	private String getLanguage(T recordInfo) {
		String result = recordInfo.codLanguage;
		
		if (result == null)
			result = DefaultValue.language();
		
		return result;
	}
	
	
	
	private boolean evaluateResult(boolean actual, boolean expected) {
		if (actual == expected)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	private SymsgInfo buildMsg(boolean evaluResult, boolean checkResult, T recordInfo, Connection dbConn, String dbSchema) {
		if (evaluResult == SUCCESS)
			return null;
		
		String codLangu = getLanguage(recordInfo);		
		int codMsg = getCodMsg(checkResult);		
		SymsgInfo msgToRead = buildMsgToRead(codMsg, codLangu);
		DeciTreeOption<SymsgInfo> option = buildOption(msgToRead, dbConn, dbSchema);
		
		return readMsg(option);	
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
		DeciTree<SymsgInfo> select = new RootSymsgSelect(option);
		select.makeDecision();	
		
		SymsgInfo result = select.getDecisionResult().getResultset().get(0);
		select.close();
		
		return result;
	}
	
	
	
	@Override public boolean getResult() {
		checkState();
		checkStateExecuted();
		
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
	
	
	
	private void checkState() {
		if (state == STATE_CLOSED) {
			logException(new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED));
			throw new IllegalStateException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkStateExecuted() {
		if (state == STATE_EXECUTED)
			return;		

		logException(new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED));
		throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
	}
	
	
	
	@Override public void close() {
		clear();
	}
	
	
	
	private void clear() {
		finalResult = DefaultValue.boole();
		expectedResult = DefaultValue.boole();
		conn = DefaultValue.object();
		schemaName = DefaultValue.object();;
		symsgData = DefaultValue.object();;
		state = STATE_CLOSED;
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
