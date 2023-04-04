package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaSetterAuthorization;

public final class SplitapaVisiEnforceAuthorization extends ActionVisitorTemplateEnforce<SplitapaInfo> {
	
	public SplitapaVisiEnforceAuthorization(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SplitapaInfo enforceHook(SplitapaInfo recordInfo) {
		InfoSetter<SplitapaInfo> setter = new SplitapaSetterAuthorization();
		return setter.setAttr(recordInfo);
	}
}
