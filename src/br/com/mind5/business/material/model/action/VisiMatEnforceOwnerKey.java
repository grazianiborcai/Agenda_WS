package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatSetterOwnerKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatEnforceOwnerKey extends ActionVisitorTemplateEnforce<MatInfo> {
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterOwnerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
