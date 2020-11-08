package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipSetterPayment;

final class VisiPaymoipEnforcePayment extends ActionVisitorTemplateEnforceV2<PaymoipInfo> {
	
	public VisiPaymoipEnforcePayment(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterPayment();
		return setter.setAttr(recordInfo);
	}
}
