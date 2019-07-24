package br.com.gda.payment.partnerMoip.multiPayMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipSetterResponseAttr;

final class VisiPaymoipEnforceResponseAttr extends ActionVisitorTemplateEnforce<PaymoipInfo> {
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
