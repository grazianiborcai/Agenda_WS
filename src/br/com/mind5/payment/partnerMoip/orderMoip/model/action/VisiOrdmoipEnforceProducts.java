package br.com.mind5.payment.partnerMoip.orderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipSetterProducts;

final class VisiOrdmoipEnforceProducts extends ActionVisitorTemplateEnforce<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo enforceHook(OrdmoipInfo recordInfo) {
		InfoSetter<OrdmoipInfo> setter = new OrdmoipSetterProducts();
		return setter.setAttr(recordInfo);
	}
}
