package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusSelect;
import br.com.gda.payService.payCustomer.model.action.StdPaycusEnforceUserKey;

public final class PaycusCheckUserTaken extends ModelCheckerTemplateAction<PaycusInfo> {
	
	public PaycusCheckUserTaken(ModelCheckerOption option) {
		super(option);
	}
	
	//TODO: adicionar checkArgument para verificar campos de busca estao preenchidos
	
	@Override protected ActionStd<PaycusInfo> buildActionHook(PaycusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PaycusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PaycusInfo> actionSelect = new StdPaycusEnforceUserKey(option);
		actionSelect.addPostAction(new LazyPaycusSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PaycusInfo> buildActionOption(PaycusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PaycusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_CUS_USER_ALREADY_EXIST)
			return SystemMessage.PAY_CUS_USER_ALREADY_EXIST;
		
		return SystemMessage.PAY_CUS_USER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PAY_CUS_USER_ALREADY_EXIST;	
			
		return SystemCode.PAY_CUS_USER_NOT_FOUND;
	}
}
