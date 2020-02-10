package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipSetterResponseAttr;

final class VisiRefumoipEnforceResponseAttr extends ActionVisitorTemplateEnforce<RefumoipInfo> {
	
	@Override protected RefumoipInfo enforceHook(RefumoipInfo recordInfo) {
		InfoSetter<RefumoipInfo> setter = new RefumoipSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
