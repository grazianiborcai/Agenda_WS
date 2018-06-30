package br.com.gda.business.customer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.decisionTree.ActionCusEnforceKeyEmail;
import br.com.gda.business.customer.model.decisionTree.HandlerCusSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CusCheckEmailChange extends ModelCheckerTemplate<CusInfo> {
	private final boolean ALREADY_EXIST = true;
	private final boolean NOT_FOUND = false;
	private final boolean FAILED = false;
	private final boolean EMPTY_RESULTSET = false;
	
	private DeciAction<CusInfo> actionSelect;
	private DeciResult<CusInfo> actionResult;
	
	
	public CusCheckEmailChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		executeAction(recordInfo, conn, schemaName);
		
		if (actionResult.hasSuccessfullyFinished() == FAILED)
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		
		if (actionResult.hasResultset() == EMPTY_RESULTSET)
			return NOT_FOUND;
		
		if (actionResult.getResultset().isEmpty())
			return NOT_FOUND;
		
		return ALREADY_EXIST;
	}
	
	
	
	private void executeAction(CusInfo recordInfo, Connection conn, String schemaName) {
		buildAction(recordInfo, conn, schemaName);
		actionSelect.executeAction();
		actionResult = actionSelect.getDecisionResult();
	}
	
	
	
	private void buildAction(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		actionSelect = new ActionCusEnforceKeyEmail(option);
		actionSelect.addPostAction(new HandlerCusSelect(conn, schemaName));
	}
	
	
	
	private DeciTreeOption<CusInfo> buildActionOption(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CUS_EMAIL_NOT_CHANGED)
			return SystemMessage.CUS_EMAIL_NOT_CHANGED;
		
		return SystemMessage.CUS_EMAIL_CHANGED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.CUS_EMAIL_NOT_CHANGED;	
			
		return SystemCode.CUS_EMAIL_CHANGED;
	}
}
