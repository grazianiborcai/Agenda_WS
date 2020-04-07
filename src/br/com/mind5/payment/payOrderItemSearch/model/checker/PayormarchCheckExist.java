package br.com.mind5.payment.payOrderItemSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.RootPayormarchSelect;

public final class PayormarchCheckExist extends ModelCheckerTemplateActionV2<PayormarchInfo, PayormarchInfo> {
	
	public PayormarchCheckExist(ModelCheckerOption option) {
		super(option, PayormarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<PayormarchInfo> buildActionHook(DeciTreeOption<PayormarchInfo> option) {
		ActionStdV1<PayormarchInfo> select = new RootPayormarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_NOT_FOUND;
	}
}
