package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.StdPayordSelect;

public final class PayordCheckExist extends ModelCheckerTemplateActionV2<PayordInfo, PayordInfo> {
	
	public PayordCheckExist(ModelCheckerOption option) {
		super(option, PayordInfo.class);
	}
	

	
	@Override protected ActionStdV1<PayordInfo> buildActionHook(DeciTreeOption<PayordInfo> option) {
		ActionStdV1<PayordInfo> select = new StdPayordSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_HEADER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_NOT_FOUND;
	}
}
