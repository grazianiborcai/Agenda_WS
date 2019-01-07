package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusSelect;
import br.com.gda.payService.payCustomer.model.action.StdPayCusEnforceUserKey;

public final class PayCusCheckUserTaken extends ModelCheckerTemplateAction<PayCusInfo> {
	
	public PayCusCheckUserTaken(ModelCheckerOption option) {
		super(option);
	}
	
	//TODO: adicionar checkArgument para verificar campos de busca estao preenchidos
	
	@Override protected ActionStd<PayCusInfo> buildActionHook(PayCusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayCusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayCusInfo> actionSelect = new StdPayCusEnforceUserKey(option);
		actionSelect.addPostAction(new LazyPayCusSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PayCusInfo> buildActionOption(PayCusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayCusInfo> option = new DeciTreeOption<>();
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
