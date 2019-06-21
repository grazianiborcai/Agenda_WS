package br.com.gda.payment.payOrder.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordSelect;
import br.com.gda.payment.payOrder.model.action.StdPayordEnforceDel;

public final class PayordCheckSoftDelete extends ModelCheckerTemplateAction<PayordInfo> {
	
	public PayordCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PayordInfo> buildActionHook(PayordInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayordInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayordInfo> actionSelect = new StdPayordEnforceDel(option);
		actionSelect.addPostAction(new LazyPayordSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PayordInfo> buildActionOption(PayordInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayordInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;	
	}
}
