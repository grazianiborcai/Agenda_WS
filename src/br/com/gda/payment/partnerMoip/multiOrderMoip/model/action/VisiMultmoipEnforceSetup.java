package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipSetterSetup;

final class VisiMultmoipEnforceSetup extends ActionVisitorTemplateEnforce<MultmoipInfo> {
	
	@Override protected MultmoipInfo enforceHook(MultmoipInfo recordInfo) {
		InfoSetter<MultmoipInfo> setter = new MultmoipSetterSetup();
		return setter.setAttr(recordInfo);
	}
}
