package br.com.mind5.masterData.paymentPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.action.PayparVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayparCheckExist extends ModelCheckerTemplateAction<PayparInfo, PayparInfo> {
	
	public PayparCheckExist(ModelCheckerOption option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected ActionStd<PayparInfo> buildActionHook(DeciTreeOption<PayparInfo> option) {
		ActionStd<PayparInfo> select = new ActionStdCommom<PayparInfo>(option, PayparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_NOT_FOUND;
	}
}
