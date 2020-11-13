package br.com.mind5.masterData.paymentStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.masterData.paymentStatus.model.action.StdPaymenusDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymenusCheckExist extends ModelCheckerTemplateActionV2<PaymenusInfo, PaymenusInfo> {
	
	public PaymenusCheckExist(ModelCheckerOption option) {
		super(option, PaymenusInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<PaymenusInfo> buildActionHook(DeciTreeOption<PaymenusInfo> option) {
		ActionStdV2<PaymenusInfo> select = new StdPaymenusDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYMENT_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYMENT_STATUS_NOT_FOUND;
	}
}
