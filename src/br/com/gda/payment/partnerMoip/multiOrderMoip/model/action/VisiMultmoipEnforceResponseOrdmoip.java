package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipSetterResponseOrdmoip;

final class VisiMultmoipEnforceResponseOrdmoip extends ActionVisitorTemplateEnforce<MultmoipInfo> {
	
	@Override protected MultmoipInfo enforceHook(MultmoipInfo recordInfo) {
		InfoSetter<MultmoipInfo> setter = new MultmoipSetterResponseOrdmoip();
		return setter.setAttr(recordInfo);
	}
}
