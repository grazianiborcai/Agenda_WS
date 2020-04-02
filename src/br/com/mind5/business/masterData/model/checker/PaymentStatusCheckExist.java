package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymentStatusCheckExist extends ModelCheckerTemplateAction<PaymentStatusInfo, PaymentStatusInfo> {
	
	public PaymentStatusCheckExist(ModelCheckerOption option) {
		super(option, PaymentStatusInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PaymentStatusInfo> buildActionHook(DeciTreeOption<PaymentStatusInfo> option) {
		ActionStdV1<PaymentStatusInfo> select = new StdPaymentStatusSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYMENT_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYMENT_STATUS_NOT_FOUND;
	}
}
