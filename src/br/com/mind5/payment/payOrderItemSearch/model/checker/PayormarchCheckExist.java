package br.com.mind5.payment.payOrderItemSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.PayormarchRootSelect;

public final class PayormarchCheckExist extends ModelCheckerTemplateAction<PayormarchInfo, PayormarchInfo> {
	
	public PayormarchCheckExist(ModelCheckerOption option) {
		super(option, PayormarchInfo.class);
	}
	

	
	@Override protected ActionStd<PayormarchInfo> buildActionHook(DeciTreeOption<PayormarchInfo> option) {
		ActionStd<PayormarchInfo> select = new PayormarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_NOT_FOUND;
	}
}
