package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparSetterDefault;

final class VisiOwnparEnforceDefault extends ActionVisitorTemplateEnforce<OwnparInfo> {
	
	@Override protected OwnparInfo enforceHook(OwnparInfo recordInfo) {
		InfoSetter<OwnparInfo> setter = new OwnparSetterDefault();
		return setter.setAttr(recordInfo);
	}
}
