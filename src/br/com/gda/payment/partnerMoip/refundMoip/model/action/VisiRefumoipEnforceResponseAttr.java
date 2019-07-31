package br.com.gda.payment.partnerMoip.refundMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipSetterResponseAttr;

final class VisiRefumoipEnforceResponseAttr extends ActionVisitorTemplateEnforce<RefumoipInfo> {
	
	@Override protected RefumoipInfo enforceHook(RefumoipInfo recordInfo) {
		InfoSetter<RefumoipInfo> setter = new RefumoipSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
