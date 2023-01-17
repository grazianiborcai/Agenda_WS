package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaSetterAuthorization;

public final class RecipaVisiEnforceAuthorization extends ActionVisitorTemplateEnforce<RecipaInfo> {
	
	public RecipaVisiEnforceAuthorization(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected RecipaInfo enforceHook(RecipaInfo recordInfo) {
		InfoSetter<RecipaInfo> setter = new RecipaSetterAuthorization();
		return setter.setAttr(recordInfo);
	}
}
