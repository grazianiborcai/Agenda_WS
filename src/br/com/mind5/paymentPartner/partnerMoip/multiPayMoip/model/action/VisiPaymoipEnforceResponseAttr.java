package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipSetterResponseAttr;

final class VisiPaymoipEnforceResponseAttr extends ActionVisitorTemplateEnforceV2<PaymoipInfo> {
	
	public VisiPaymoipEnforceResponseAttr(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
