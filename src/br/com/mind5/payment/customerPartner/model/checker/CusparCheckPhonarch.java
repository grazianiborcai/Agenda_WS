package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelectUserPhone;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPhonarch extends ModelCheckerTemplateAction<CusparInfo, PhonarchInfo> {	
	
	public CusparCheckPhonarch(ModelCheckerOption option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonarchInfo> buildActionHook(DeciTreeOption<PhonarchInfo> option) {
		ActionStd<PhonarchInfo> select = new PhonarchRootSelectUserPhone(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_INVALID_PHONE;
	}
}
