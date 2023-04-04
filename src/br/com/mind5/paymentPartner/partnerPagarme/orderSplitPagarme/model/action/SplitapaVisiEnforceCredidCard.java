package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info.SplitapaSetterCredidCard;

public final class SplitapaVisiEnforceCredidCard extends ActionVisitorTemplateEnforce<SplitapaInfo> {
	
	public SplitapaVisiEnforceCredidCard(DeciTreeOption<SplitapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SplitapaInfo enforceHook(SplitapaInfo recordInfo) {
		InfoSetter<SplitapaInfo> setter = new SplitapaSetterCredidCard();
		return setter.setAttr(recordInfo);
	}
}
