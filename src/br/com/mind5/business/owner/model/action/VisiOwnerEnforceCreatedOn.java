package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOwnerEnforceCreatedOn extends ActionVisitorTemplateEnforce<OwnerInfo> {
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		InfoSetter<OwnerInfo> attrSetter = new OwnerSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
