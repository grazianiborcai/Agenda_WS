package br.com.mind5.model.action.commom;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.language.info.Langu;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionStdFailedTemplate<T extends InfoRecord> implements ActionStd<T> {
	private ActionStd<T> helper;
	
	
	public ActionStdFailedTemplate(DeciTreeOption<T> option, int codMsg) {
		checkArgument(option, codMsg);
		
		SymsgInfo msg = getMsg(option, codMsg);
		helper = new ActionStdDummy<>(buildDeciResult(msg));
	}
	
	
	
	private DeciResult<T> buildDeciResult(SymsgInfo msg) {
		final boolean FAILED = false;
		
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess    = FAILED;
		deciResult.hasResultset = FAILED;		
		deciResult.failMessage  = msg.txtMsg;
		deciResult.failCode     = msg.codMsg;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		helper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return helper.executeAction();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return helper.getDecisionResult();
	}
	
	
	
	@Override public void close() {
		closeHelper(helper);
		clear();
	}
	
	
	
	private SymsgInfo getMsg(DeciTreeOption<T> option, int codMsg) {
		String langu = getLangu(option);
		
		SystemMessageBuilder builder = new SystemMessageBuilder(option.conn, option.schemaName, langu, codMsg);
		return builder.build();
	}
	
	
	
	private String getLangu(DeciTreeOption<T> option) {
		String langu = Langu.DEFAULT.getCod();
		
		if (option.recordInfos == null)
			return langu;
		
		if (option.recordInfos.isEmpty())
			return langu;
		
		InfoRecord oneRecord = option.recordInfos.get(0);
		
		if (oneRecord.codLanguage != null)
			langu = oneRecord.codLanguage;
		
		return langu;
	}
	
	
	
	private void closeHelper(ActionStd<T> actionHelper) {
		if (actionHelper == null)
			return;
		
		actionHelper.close();
	}
	
	
	
	private void clear() {
		helper = DefaultValue.object();
	}
	
	
	
	private void checkArgument(DeciTreeOption<T> option, int codMsg) {
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.recordInfos == null) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
				
		
		if (option.recordInfos.isEmpty()) {
			logException(new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("option.recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		if (codMsg <= 0) {
			logException(new NullPointerException("codMsg" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("codMsg" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
