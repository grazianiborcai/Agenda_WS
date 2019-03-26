package br.com.gda.business.materialText.model.action;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.info.MatextSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatextEnforceLChanged extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
