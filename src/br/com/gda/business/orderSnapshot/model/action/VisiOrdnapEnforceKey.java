package br.com.gda.business.orderSnapshot.model.action;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.business.orderSnapshot.info.OrdnapSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrdnapEnforceKey extends ActionVisitorTemplateEnforce<OrdnapInfo> {
	
	@Override protected OrdnapInfo enforceHook(OrdnapInfo recordInfo) {
		InfoSetter<OrdnapInfo> setter = new OrdnapSetterKey();
		return setter.setAttr(recordInfo);
	}
}
