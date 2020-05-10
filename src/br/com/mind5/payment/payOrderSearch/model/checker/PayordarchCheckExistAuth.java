package br.com.mind5.payment.payOrderSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.decisionTree.RootPayordarchSelect;

public final class PayordarchCheckExistAuth extends ModelCheckerTemplateActionV2<PayordarchInfo, PayordarchInfo> {
	
	public PayordarchCheckExistAuth(ModelCheckerOption option) {
		super(option, PayordarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<PayordarchInfo> buildActionHook(DeciTreeOption<PayordarchInfo> option) {
		ActionStdV1<PayordarchInfo> select = new RootPayordarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_SEARCH_NOT_ALLOWED;
	}
}
