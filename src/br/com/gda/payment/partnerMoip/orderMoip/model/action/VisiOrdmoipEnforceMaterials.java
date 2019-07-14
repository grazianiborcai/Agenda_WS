package br.com.gda.payment.partnerMoip.orderMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipSetterMaterials;

final class VisiOrdmoipEnforceMaterials extends ActionVisitorTemplateEnforce<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo enforceHook(OrdmoipInfo recordInfo) {
		InfoSetter<OrdmoipInfo> setter = new OrdmoipSetterMaterials();
		return setter.setAttr(recordInfo);
	}
}
