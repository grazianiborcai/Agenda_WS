package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaSetterAuthorization;

public final class CrecapaVisiEnforceAuthorization extends ActionVisitorTemplateEnforce<CrecapaInfo> {
	
	public CrecapaVisiEnforceAuthorization(DeciTreeOption<CrecapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CrecapaInfo enforceHook(CrecapaInfo recordInfo) {
		InfoSetter<CrecapaInfo> setter = new CrecapaSetterAuthorization();
		return setter.setAttr(recordInfo);
	}
}
