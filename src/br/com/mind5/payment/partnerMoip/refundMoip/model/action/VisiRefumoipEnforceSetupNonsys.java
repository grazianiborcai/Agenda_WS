package br.com.mind5.payment.partnerMoip.refundMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipSetterSetupNonsys;

final class VisiRefumoipEnforceSetupNonsys extends ActionVisitorTemplateEnforce<RefumoipInfo> {
	
	@Override protected RefumoipInfo enforceHook(RefumoipInfo recordInfo) {
		InfoSetter<RefumoipInfo> setter = new RefumoipSetterSetupNonsys();
		return setter.setAttr(recordInfo);
	}
}
