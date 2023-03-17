package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaSetterResponseAttr;

public final class OrdapaVisiEnforceResponseAttr extends ActionVisitorTemplateEnforce<OrdapaInfo> {
	
	public OrdapaVisiEnforceResponseAttr(DeciTreeOption<OrdapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdapaInfo enforceHook(OrdapaInfo recordInfo) {
		InfoSetter<OrdapaInfo> setter = new OrdapaSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
