package br.com.mind5.payment.partnerMoip.refundMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipSetterSetupSys;

final class VisiRefumoipEnforceSetupSys extends ActionVisitorTemplateEnforce<RefumoipInfo> {
	
	@Override protected RefumoipInfo enforceHook(RefumoipInfo recordInfo) {
		InfoSetter<RefumoipInfo> setter = new RefumoipSetterSetupSys();
		return setter.setAttr(recordInfo);
	}
}
