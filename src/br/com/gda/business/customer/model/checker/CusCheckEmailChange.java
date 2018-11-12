package br.com.gda.business.customer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.StdCusEnforceKeyEmail;
import br.com.gda.business.customer.model.action.LazyCusSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CusCheckEmailChange extends ModelCheckerTemplateAction<CusInfo> {
	
	public CusCheckEmailChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CusInfo> buildActionHook(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CusInfo> actionSelect = new StdCusEnforceKeyEmail(option);
		actionSelect.addPostAction(new LazyCusSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CusInfo> buildActionOption(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CUS_EMAIL_NOT_CHANGED)
			return SystemMessage.CUS_EMAIL_NOT_CHANGED;
		
		return SystemMessage.CUS_EMAIL_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.CUS_EMAIL_NOT_CHANGED;	
			
		return SystemCode.CUS_EMAIL_CHANGED;
	}
}
