package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatSetterCategKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatEnforceCategKey extends ActionVisitorTemplateEnforce<MatInfo> {
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterCategKey();
		return attrSetter.setAttr(recordInfo);
	}
}
