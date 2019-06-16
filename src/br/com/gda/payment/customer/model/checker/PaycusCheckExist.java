package br.com.gda.payment.customer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.model.action.LazyPaycusSelect;
import br.com.gda.payment.customer.model.action.StdPaycusEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PaycusCheckExist extends ModelCheckerTemplateAction<PaycusInfo> {
	
	public PaycusCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PaycusInfo> buildActionHook(PaycusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PaycusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PaycusInfo> actionSelect = new StdPaycusEnforceKey(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_ALREADY_EXIST)
			return SystemMessage.CART_ALREADY_EXIST;
		
		return SystemMessage.CART_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CART_ALREADY_EXIST;	
		
		return SystemCode.CART_NOT_FOUND;
	}
}
