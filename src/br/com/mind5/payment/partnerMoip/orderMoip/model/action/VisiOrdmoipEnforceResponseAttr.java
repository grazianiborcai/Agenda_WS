package br.com.mind5.payment.partnerMoip.orderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipSetterResponseAttr;

final class VisiOrdmoipEnforceResponseAttr extends ActionVisitorTemplateEnforce<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo enforceHook(OrdmoipInfo recordInfo) {
		InfoSetter<OrdmoipInfo> setter = new OrdmoipSetterResponseAttr();
		return setter.setAttr(recordInfo);
	}
}
