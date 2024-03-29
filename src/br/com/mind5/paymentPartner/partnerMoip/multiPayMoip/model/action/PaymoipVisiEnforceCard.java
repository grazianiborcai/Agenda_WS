package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipSetterCard;

public final class PaymoipVisiEnforceCard extends ActionVisitorTemplateEnforce<PaymoipInfo> {
	
	public PaymoipVisiEnforceCard(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterCard();
		return setter.setAttr(recordInfo);
	}
}
