package br.com.mind5.payment.customerPartner.model.checker;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.RootPhonarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPhonarch extends ModelCheckerTemplateActionV2<CusparInfo, PhonarchInfo> {	
	
	public CusparCheckPhonarch(ModelCheckerOption option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<PhonarchInfo> buildActionHook(DeciTreeOption<PhonarchInfo> option) {
		ActionStdV2<PhonarchInfo> select = new RootPhonarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<PhonarchInfo> toActionClassHook(List<CusparInfo> recordInfos) {
		return PhonarchCopier.copyFromCuspar(recordInfos);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_INVALID_PHONE;
	}
}
