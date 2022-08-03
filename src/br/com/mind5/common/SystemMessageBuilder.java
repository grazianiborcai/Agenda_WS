package br.com.mind5.common;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.SymsgRootSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SystemMessageBuilder {
	private Connection conn;
	private String schemaName;
	private String codLanguageBase;
	private int codMsgMain;
	private Map<Integer, Integer> params;
	
	
	public SystemMessageBuilder(Connection dbConn, String dbSchema, String codLanguage, int codMsg) {
		super();		
		
		checkArgument(dbConn, dbSchema, codLanguage, codMsg);
		init();
		
		conn = dbConn;
		schemaName = dbSchema;
		codLanguageBase = codLanguage;
		codMsgMain = codMsg;
	}
	
	
	
	private void init() {
		codMsgMain = DefaultValue.number();
		codLanguageBase = DefaultValue.language();
		params = new HashMap<>(3);
	}
	
	
	
	public SystemMessageBuilder addParam01(int codMsg) {
		checkArgument(codMsg);
		params.put(1, codMsg);		
		return this;
	}
	
	
	
	public SystemMessageBuilder addParam02(int codMsg) {
		checkArgument(codMsg);
		params.put(2, codMsg);		
		return this;
	}
	
	
	
	public SystemMessageBuilder addParam03(int codMsg) {
		checkArgument(codMsg);
		params.put(3, codMsg);		
		return this;
	}
	
	
	
	public SymsgInfo build() {
		SymsgInfo msgMain    = readMsgMain   (conn, schemaName, codLanguageBase, codMsgMain);
		SymsgInfo msgParam01 = readMsgParam01(conn, schemaName, codLanguageBase, params    );
		SymsgInfo msgParam02 = readMsgParam02(conn, schemaName, codLanguageBase, params    );
		SymsgInfo msgParam03 = readMsgParam03(conn, schemaName, codLanguageBase, params    );
		
		return concatenateSymsg(msgMain, msgParam01, msgParam02, msgParam03);
	}
	
	
	
	private SymsgInfo readMsgMain(Connection dbConn, String dbSchema, String codLanguage, int codMsg) {
		SymsgInfo symsg = initMsg(codLanguage, codMsg);
		return readSymsg(dbConn, dbSchema, symsg);
	}
	
	
	
	private SymsgInfo readMsgParam01(Connection dbConn, String dbSchema, String codLanguage, Map<Integer, Integer> allParams) {
		int codMsg = getParam01(allParams);
		
		if (codMsg <= 0)
			return null;
		
		SymsgInfo symsg = initMsg(codLanguage, codMsg);
		return readSymsg(dbConn, dbSchema, symsg);
	}
	
	
	
	private SymsgInfo readMsgParam02(Connection dbConn, String dbSchema, String codLanguage, Map<Integer, Integer> allParams) {
		int codMsg = getParam02(allParams);
		
		if (codMsg <= 0)
			return null;
		
		SymsgInfo symsg = initMsg(codLanguage, codMsg);
		return readSymsg(dbConn, dbSchema, symsg);
	}
	
	
	
	private SymsgInfo readMsgParam03(Connection dbConn, String dbSchema, String codLanguage, Map<Integer, Integer> allParams) {
		int codMsg = getParam03(allParams);
		
		if (codMsg <= 0)
			return null;
		
		SymsgInfo symsg = initMsg(codLanguage, codMsg);
		return readSymsg(dbConn, dbSchema, symsg);
	}
	
	
	
	private int getParam01(Map<Integer, Integer> allParams) {
		return getParam(allParams, 1);
	}
	
	
	
	private int getParam02(Map<Integer, Integer> allParams) {
		return getParam(allParams, 2);
	}
	
	
	
	private int getParam03(Map<Integer, Integer> allParams) {
		return getParam(allParams, 3);
	}
	
	
	
	private int getParam(Map<Integer, Integer> allParams, int key) {
		if (allParams == null)
			return DefaultValue.number();
		
		if (allParams.isEmpty())
			return DefaultValue.number();
		
		Integer result = allParams.get(key);
		
		if (result == null)
			return DefaultValue.number();
		
		return result;
	}
	
	
	
	private SymsgInfo initMsg(String codLanguage, int codMsg) {
		SymsgInfo symsg = new SymsgInfo();
		
		symsg.codLanguage     = codLanguage;
		symsg.codLanguageBase = codLanguage;
		symsg.codMsg          = codMsg;
		
		return symsg;
	}
	
	
	
	private SymsgInfo readSymsg(Connection dbConn, String dbSchema, SymsgInfo symsg) {
		DeciTreeOption<SymsgInfo> option = buildOption(dbConn, dbSchema, symsg);
		DeciResult<SymsgInfo> deciResult = executeSymsgRootSelect(option);
		checkArgument(deciResult);
		
		return getFirstResultOnList(deciResult.getResultset());
	}
	
	
	
	private DeciTreeOption<SymsgInfo> buildOption(Connection dbConn, String dbSchema, SymsgInfo symsg) {
		DeciTreeOption<SymsgInfo> option = new DeciTreeOption<>();
		
		option.conn = dbConn;
		option.schemaName = dbSchema;
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(symsg);		
		
		return option;
	}
	
	
	
	private DeciResult<SymsgInfo> executeSymsgRootSelect(DeciTreeOption<SymsgInfo> option) {
		ActionStd<SymsgInfo> select = new SymsgRootSelect(option).toAction();
		select.executeAction();
		
		return select.getDecisionResult();
	}
	
	
	
	private SymsgInfo getFirstResultOnList(List<SymsgInfo> results) {
		checkArgument(results);
		return results.get(0);
	}
	
	
	
	private SymsgInfo concatenateSymsg(SymsgInfo msgMain, SymsgInfo msgParam01, SymsgInfo msgParam02, SymsgInfo msgParam03) {
		String msgMainTxt = msgMain.txtMsg;
		
		msgMainTxt = concatenateParam(msgMainTxt, msgParam01, "&1");
		msgMainTxt = concatenateParam(msgMainTxt, msgParam02, "&2");
		msgMainTxt = concatenateParam(msgMainTxt, msgParam03, "&3");
		
		msgMain.txtMsg = msgMainTxt;
		return msgMain;
	}
	
	
	
	private String concatenateParam(String msgMainTxt, SymsgInfo msgParam, String placeholder) {
		if (msgParam == null)
			return msgMainTxt;
		
		String msgParamTxt = msgParam.txtMsg;
		msgMainTxt.replace(placeholder, msgParamTxt);
		
		return msgMainTxt;
	}
	
	
	
	private void checkArgument(Connection dbConn, String dbSchema, String codLanguage, int codMsg) {
		if (dbConn == null) {
			logException(new NullPointerException("dbConn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("dbConn" + SystemMessage.NULL_ARGUMENT);
		}
		
		if (dbSchema == null) {
			logException(new NullPointerException("dbSchema" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("dbSchema" + SystemMessage.NULL_ARGUMENT);
		}
		
		if (codLanguage == null) {
			logException(new NullPointerException("codLanguage" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("codLanguage" + SystemMessage.NULL_ARGUMENT);
		}
		
		checkArgument(codMsg);
	}
	
	
	
	private void checkArgument(int codMsg) {
		if (codMsg <= 0) {
			logException(new NullPointerException("codMsg" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("codMsg" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void checkArgument(DeciResult<SymsgInfo> deciResult) {
		if (deciResult == null) {
			logException(new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT);
		}
		
		if (deciResult.isSuccess() == false) {
			logException(new NullPointerException("deciResult" + SystemMessage.NO_MSG_FOUND));
			throw new NullPointerException("deciResult" + SystemMessage.NO_MSG_FOUND);
		}		
		
		if (deciResult.hasResultset() == false) {
			logException(new NullPointerException("deciResult" + SystemMessage.NO_MSG_FOUND));
			throw new NullPointerException("deciResult" + SystemMessage.NO_MSG_FOUND);
		}
	}
	
	
	
	private void checkArgument(List<?> resultset) {
		if (resultset == null) {
			logException(new NullPointerException("resultset" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("resultset" + SystemMessage.NULL_ARGUMENT);
		}
		
		if (resultset.isEmpty()) {
			logException(new NullPointerException("resultset" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("resultset" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
