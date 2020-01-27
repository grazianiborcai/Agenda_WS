package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymentStatusCheckExist extends ModelCheckerTemplateActionV2<PaymentStatusInfo, PaymentStatusInfo> {
	
	public PaymentStatusCheckExist(ModelCheckerOption option) {
		super(option, PaymentStatusInfo.class);
	}
	
	
	
	@Override protected ActionStd<PaymentStatusInfo> buildActionHook(DeciTreeOption<PaymentStatusInfo> option) {
		ActionStd<PaymentStatusInfo> select = new StdPaymentStatusSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYMENT_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYMENT_STATUS_NOT_FOUND;
	}
}
