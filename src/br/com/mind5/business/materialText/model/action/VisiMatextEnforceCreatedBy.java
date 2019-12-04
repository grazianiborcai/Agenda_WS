package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatextEnforceCreatedBy extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
