package br.com.gda.business.material.model.action;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatSetterCategKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatEnforceCategKey extends ActionVisitorTemplateEnforce<MatInfo> {
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterCategKey();
		return attrSetter.setAttr(recordInfo);
	}
}
