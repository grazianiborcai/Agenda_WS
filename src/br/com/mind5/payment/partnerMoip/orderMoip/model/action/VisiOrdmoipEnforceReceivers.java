package br.com.mind5.payment.partnerMoip.orderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipSetterReceivers;

final class VisiOrdmoipEnforceReceivers extends ActionVisitorTemplateEnforce<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo enforceHook(OrdmoipInfo recordInfo) {
		InfoSetter<OrdmoipInfo> setter = new OrdmoipSetterReceivers();
		return setter.setAttr(recordInfo);
	}
}
