package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatSetterKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatEnforceKey extends ActionVisitorTemplateEnforce<MatInfo> {
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
