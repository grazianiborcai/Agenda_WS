package br.com.mind5.payment.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipSetterPayment;

final class VisiPaymoipEnforcePayment extends ActionVisitorTemplateEnforce<PaymoipInfo> {
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterPayment();
		return setter.setAttr(recordInfo);
	}
}
