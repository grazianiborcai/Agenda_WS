package br.com.gda.business.owner.model.action;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerSetterCodUserCateg;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOwnerEnforceUserCateg extends ActionVisitorTemplateEnforce<OwnerInfo> {
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		InfoSetter<OwnerInfo> attrSetter = new OwnerSetterCodUserCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
