package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipSetterResponseOrdmoip;

final class VisiMultmoipEnforceResponseOrdmoip extends ActionVisitorTemplateEnforce<MultmoipInfo> {
	
	@Override protected MultmoipInfo enforceHook(MultmoipInfo recordInfo) {
		InfoSetter<MultmoipInfo> setter = new MultmoipSetterResponseOrdmoip();
		return setter.setAttr(recordInfo);
	}
}
