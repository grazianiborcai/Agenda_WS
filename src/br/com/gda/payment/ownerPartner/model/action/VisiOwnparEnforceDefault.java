package br.com.gda.payment.ownerPartner.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.info.OwnparSetterDefault;

final class VisiOwnparEnforceDefault extends ActionVisitorTemplateEnforce<OwnparInfo> {
	
	@Override protected OwnparInfo enforceHook(OwnparInfo recordInfo) {
		InfoSetter<OwnparInfo> setter = new OwnparSetterDefault();
		return setter.setAttr(recordInfo);
	}
}
