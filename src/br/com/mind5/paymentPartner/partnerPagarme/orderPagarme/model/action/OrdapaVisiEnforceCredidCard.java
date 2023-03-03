package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaSetterCredidCard;

public final class OrdapaVisiEnforceCredidCard extends ActionVisitorTemplateEnforce<OrdapaInfo> {
	
	public OrdapaVisiEnforceCredidCard(DeciTreeOption<OrdapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdapaInfo enforceHook(OrdapaInfo recordInfo) {
		InfoSetter<OrdapaInfo> setter = new OrdapaSetterCredidCard();
		return setter.setAttr(recordInfo);
	}
}
