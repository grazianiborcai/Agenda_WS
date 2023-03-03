package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaSetterCustomerId;

public final class OrdapaVisiEnforceCustomerId extends ActionVisitorTemplateEnforce<OrdapaInfo> {
	
	public OrdapaVisiEnforceCustomerId(DeciTreeOption<OrdapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdapaInfo enforceHook(OrdapaInfo recordInfo) {
		InfoSetter<OrdapaInfo> setter = new OrdapaSetterCustomerId();
		return setter.setAttr(recordInfo);
	}
}
