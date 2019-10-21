package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextSetterKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatextEnforceKey extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
