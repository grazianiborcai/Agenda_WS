package br.com.mind5.business.orderSnapshot.model.action;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapSetterKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOrdnapEnforceKey extends ActionVisitorTemplateEnforce<OrdnapInfo> {
	
	@Override protected OrdnapInfo enforceHook(OrdnapInfo recordInfo) {
		InfoSetter<OrdnapInfo> setter = new OrdnapSetterKey();
		return setter.setAttr(recordInfo);
	}
}
