package br.com.mind5.masterData.paymentStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.masterData.paymentStatus.model.action.PaymenusVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymenusCheckExist extends ModelCheckerTemplateAction<PaymenusInfo, PaymenusInfo> {
	
	public PaymenusCheckExist(ModelCheckerOption option) {
		super(option, PaymenusInfo.class);
	}
	
	
	
	@Override protected ActionStd<PaymenusInfo> buildActionHook(DeciTreeOption<PaymenusInfo> option) {
		ActionStd<PaymenusInfo> select = new ActionStdCommom<PaymenusInfo>(option, PaymenusVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYMENT_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYMENT_STATUS_NOT_FOUND;
	}
}
