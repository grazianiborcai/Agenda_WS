package br.com.mind5.payment.payOrderSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.decisionTree.PayordarchRootSelect;

public final class PayordarchCheckExist extends ModelCheckerTemplateAction<PayordarchInfo, PayordarchInfo> {
	
	public PayordarchCheckExist(ModelCheckerOption option) {
		super(option, PayordarchInfo.class);
	}
	

	
	@Override protected ActionStd<PayordarchInfo> buildActionHook(DeciTreeOption<PayordarchInfo> option) {
		ActionStd<PayordarchInfo> select = new PayordarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_SEARCH_NOT_FOUND;
	}
}
