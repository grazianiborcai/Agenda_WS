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
import br.com.gda.payService.payCustomer.model.action.StdPayCusEnforcePersonChange;

public final class PayCusCheckPersonChange extends ModelCheckerTemplateAction<PayCusInfo> {
	
	public PayCusCheckPersonChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PayCusInfo> buildActionHook(PayCusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayCusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayCusInfo> actionSelect = new StdPayCusEnforcePersonChange(option);
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
