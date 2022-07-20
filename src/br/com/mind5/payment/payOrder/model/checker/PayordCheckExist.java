package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiDaoSelect;

public final class PayordCheckExist extends ModelCheckerTemplateAction<PayordInfo, PayordInfo> {
	
	public PayordCheckExist(ModelCheckerOption option) {
		super(option, PayordInfo.class);
	}
	

	
	@Override protected ActionStd<PayordInfo> buildActionHook(DeciTreeOption<PayordInfo> option) {
		ActionStd<PayordInfo> select = new ActionStdCommom<PayordInfo>(option, PayordVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_HEADER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_NOT_FOUND;
	}
}
