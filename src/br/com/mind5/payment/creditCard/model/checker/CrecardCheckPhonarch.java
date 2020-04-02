package br.com.mind5.payment.creditCard.model.checker;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.RootPhonarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckPhonarch extends ModelCheckerTemplateAction<CrecardInfo, PhonarchInfo> {	
	
	public CrecardCheckPhonarch(ModelCheckerOption option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PhonarchInfo> buildActionHook(DeciTreeOption<PhonarchInfo> option) {
		ActionStdV1<PhonarchInfo> select = new RootPhonarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<PhonarchInfo> toActionClassHook(List<CrecardInfo> recordInfos) {
		return PhonarchCopier.copyFromCrecard(recordInfos);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_INVALID_PHONE;
	}
}
