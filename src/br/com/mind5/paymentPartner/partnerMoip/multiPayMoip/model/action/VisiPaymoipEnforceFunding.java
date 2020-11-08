package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipSetterFunding;

final class VisiPaymoipEnforceFunding extends ActionVisitorTemplateEnforceV2<PaymoipInfo> {
	
	public VisiPaymoipEnforceFunding(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterFunding();
		return setter.setAttr(recordInfo);
	}
}
