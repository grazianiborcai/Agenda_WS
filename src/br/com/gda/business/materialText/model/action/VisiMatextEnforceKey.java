package br.com.gda.business.materialText.model.action;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.info.MatextSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatextEnforceKey extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
