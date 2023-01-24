package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaSetterMetadata;

public final class CrecapaVisiEnforceMetadata extends ActionVisitorTemplateEnforce<CrecapaInfo> {
	
	public CrecapaVisiEnforceMetadata(DeciTreeOption<CrecapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CrecapaInfo enforceHook(CrecapaInfo recordInfo) {
		InfoSetter<CrecapaInfo> setter = new CrecapaSetterMetadata();
		return setter.setAttr(recordInfo);
	}
}
