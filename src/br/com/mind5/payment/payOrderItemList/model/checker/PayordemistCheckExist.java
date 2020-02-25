package br.com.mind5.payment.payOrderItemList.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.RootPayordemistSelect;

public final class PayordemistCheckExist extends ModelCheckerTemplateActionV2<PayordemistInfo, PayordemistInfo> {
	
	public PayordemistCheckExist(ModelCheckerOption option) {
		super(option, PayordemistInfo.class);
	}
	

	
	@Override protected ActionStd<PayordemistInfo> buildActionHook(DeciTreeOption<PayordemistInfo> option) {
		ActionStd<PayordemistInfo> select = new RootPayordemistSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_ITEM_LIST_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_LIST_NOT_FOUND;
	}
}
