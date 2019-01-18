package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PaymentStatusCheckExist extends ModelCheckerTemplateAction<PaymentStatusInfo> {
	
	public PaymentStatusCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PaymentStatusInfo> buildActionHook(PaymentStatusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PaymentStatusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PaymentStatusInfo> actionSelect = new StdPaymentStatusSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PaymentStatusInfo> buildActionOption(PaymentStatusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PaymentStatusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PAYMENT_STATUS_ALREADY_EXIST)
			return SystemMessage.PAYMENT_STATUS_ALREADY_EXIST;
		
		return SystemMessage.PAYMENT_STATUS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PAYMENT_STATUS_ALREADY_EXIST;	
			
		return SystemCode.PAYMENT_STATUS_NOT_FOUND;
	}
}
