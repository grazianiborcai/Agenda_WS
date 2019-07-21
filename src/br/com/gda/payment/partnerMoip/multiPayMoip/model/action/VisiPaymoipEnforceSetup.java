package br.com.gda.payment.partnerMoip.multiPayMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipSetterSetup;

final class VisiPaymoipEnforceSetup extends ActionVisitorTemplateEnforce<PaymoipInfo> {
	
	@Override protected PaymoipInfo enforceHook(PaymoipInfo recordInfo) {
		InfoSetter<PaymoipInfo> setter = new PaymoipSetterSetup();
		return setter.setAttr(recordInfo);
	}
}
