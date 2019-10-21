package br.com.mind5.payment.payOrderSearch.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.RootPayordSelect;

public final class PayordCheckExist extends ModelCheckerTemplateAction_<PayordInfo> {
	
	public PayordCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PayordInfo> buildActionHook(PayordInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayordInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayordInfo> select = new RootPayordSelect(option).toAction();
		return select;
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
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_ORDER_ALREADY_EXIST)
			return SystemMessage.PAY_ORDER_ALREADY_EXIST;
		
		return SystemMessage.PAY_ORDER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_ORDER_ALREADY_EXIST;	
			
		return SystemCode.PAY_ORDER_NOT_FOUND;
	}
}
