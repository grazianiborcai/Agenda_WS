package br.com.mind5.business.orderSnapshot.model.action;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapSetterKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiOrdnapEnforceKey extends ActionVisitorTemplateEnforceV1<OrdnapInfo> {
	
	@Override protected OrdnapInfo enforceHook(OrdnapInfo recordInfo) {
		InfoSetter<OrdnapInfo> setter = new OrdnapSetterKey();
		return setter.setAttr(recordInfo);
	}
}
