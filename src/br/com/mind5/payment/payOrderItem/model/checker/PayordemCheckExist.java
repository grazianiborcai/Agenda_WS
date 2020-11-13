package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemDaoSelect;

public final class PayordemCheckExist extends ModelCheckerTemplateActionV2<PayordemInfo, PayordemInfo> {
	
	public PayordemCheckExist(ModelCheckerOption option) {
		super(option, PayordemInfo.class);
	}
	

	
	@Override protected ActionStdV2<PayordemInfo> buildActionHook(DeciTreeOption<PayordemInfo> option) {
		ActionStdV2<PayordemInfo> select = new StdPayordemDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_ITEM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_NOT_FOUND;
	}
}
