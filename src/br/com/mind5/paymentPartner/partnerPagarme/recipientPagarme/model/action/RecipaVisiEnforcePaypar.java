package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaSetterPaypar;

public final class RecipaVisiEnforcePaypar extends ActionVisitorTemplateEnforce<RecipaInfo> {
	
	public RecipaVisiEnforcePaypar(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected RecipaInfo enforceHook(RecipaInfo recordInfo) {
		InfoSetter<RecipaInfo> setter = new RecipaSetterPaypar();
		return setter.setAttr(recordInfo);
	}
}
