package br.com.mind5.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.RootSymsgSelect;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionVisitorTemplateSimple<T extends InfoRecord> implements ActionVisitor<T> {
	private List<T> bases;
	private String codLanguage;
	private Connection conn;
	private String schemaName;
	
	
	public ActionVisitorTemplateSimple(DeciTreeOption<T> option) {
		checkArgument(option);	
		clear();
		
		bases = getBaseInfos(option);	
		codLanguage = getLanguage(bases);
		conn = option.conn;
		schemaName = option.schemaName;
	}
	
	
	
	private List<T> getBaseInfos(DeciTreeOption<T> option) {
		return makeClone(option.recordInfos);
	}
	
	
	
	private String getLanguage(List<T> baseInfos) {
		return baseInfos.get(0).codLanguage;
	}
	
	

	@Override public DeciResult<T> executeTransformation() {
		List<T> resultInfos = executeTransformationHook(bases);
		return makeResult(resultInfos, codLanguage, conn, schemaName);
	}
	
	
	
	protected List<T> executeTransformationHook(List<T> basesInfos) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciResult<T> makeResult(List<T> resultInfos, String codLangu, Connection dbConn, String dbSchema) {
		if (resultInfos == null)
			return makeResultError(codLangu, dbConn, dbSchema);
		
		if (resultInfos.isEmpty())
			return makeResultError(codLangu, dbConn, dbSchema);
		
		return makeSuccessResult(resultInfos);
	}
	
	
	
	private DeciResult<T> makeSuccessResult(List<T> enforcedInfos) {
		DeciResultHelper<T> helper = new DeciResultHelper<>();
		
		helper.resultset = enforcedInfos;
		helper.isSuccess = true;
		helper.hasResultset = true;
		
		return helper;
	}
	
	
	
	private DeciResult<T> makeResultError(String codLangu, Connection dbConn, String dbSchema) {
		DeciResultHelper<T> helper = new DeciResultHelper<>();
		
		helper.failCode = getErrorCodeHook();
		helper.failMessage = getErrorMessage(helper.failCode, codLangu, dbConn, dbSchema);
		helper.hasResultset = false;
		helper.isSuccess = false;
		
		return helper;
	}
	
	
	
	protected int getErrorCodeHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private String getErrorMessage(int codMsg, String codLangu, Connection dbConn, String dbSchema) {
		SymsgInfo symsgToRead = buildMsgToRead(codMsg, codLangu);
		DeciTreeOption<SymsgInfo> option = buildOption(symsgToRead, dbConn, dbSchema);
		
		return readSymsg(option).txtMsg;	
	}
	
	
	
	private SymsgInfo buildMsgToRead(int codMsg, String codLangu) {
		SymsgInfo symsg = new SymsgInfo();
		symsg.codMsg = codMsg;
		symsg.codLanguage = codLangu;
		
		return symsg;
	}
	
	
	
	private SymsgInfo readSymsg(DeciTreeOption<SymsgInfo> option) {
		DeciTree<SymsgInfo> select = new RootSymsgSelect(option);
		select.makeDecision();	
		
		SymsgInfo result = select.getDecisionResult().getResultset().get(0);
		select.close();
		
		return result;
	}
	
	
	
	private DeciTreeOption<SymsgInfo> buildOption(SymsgInfo symsg, Connection dbConn, String dbSchema) {
		DeciTreeOption<SymsgInfo> option = new DeciTreeOption<>();
		
		option.conn = dbConn;
		option.schemaName = dbSchema;
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(symsg);		
		
		return option;
	}	
	
	
	
	@Override public void close() {
		clear();
	}
	
	
	
	private void clear() {
		bases = DefaultValue.list();
		codLanguage = DefaultValue.language();
		conn = DefaultValue.object();
		schemaName = DefaultValue.object();
	}
	
	
	
	private List<T> makeClone(List<T> recordInfos) {
		return CloneUtil.cloneRecords(recordInfos, this.getClass());
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option) {
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
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		if (option.recordInfos.isEmpty()) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	protected void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
