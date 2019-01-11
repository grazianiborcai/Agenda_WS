package br.com.gda.business.owner.model.action;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerSetterCompKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOwnerEnforceCompKey extends ActionVisitorTemplateEnforce<OwnerInfo> {
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		InfoSetter<OwnerInfo> attrSetter = new OwnerSetterCompKey();
		return attrSetter.setAttr(recordInfo);
	}
}
