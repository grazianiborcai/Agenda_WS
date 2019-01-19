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
import br.com.gda.payService.payCustomer.model.action.StdPaycusEnforcePersonChange;

public final class PaycusCheckPersonChange extends ModelCheckerTemplateAction<PaycusInfo> {
	
	public PaycusCheckPersonChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PaycusInfo> buildActionHook(PaycusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PaycusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PaycusInfo> actionSelect = new StdPaycusEnforcePersonChange(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_CUS_PERSON_NOT_CHANGED)
			return SystemMessage.PAY_CUS_PERSON_NOT_CHANGED;
		
		return SystemMessage.PAY_CUS_PERSON_CANT_BE_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PAY_CUS_PERSON_NOT_CHANGED;	
			
		return SystemCode.PAY_CUS_PERSON_CANT_BE_CHANGED;
	}
}
