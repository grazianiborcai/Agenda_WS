package br.com.gda.business.materialStore.model.action;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatoreEnforceLChanged extends ActionVisitorTemplateEnforce<MatoreInfo> {
	
	@Override protected MatoreInfo enforceHook(MatoreInfo recordInfo) {
		InfoSetter<MatoreInfo> attrSetter = new MatoreSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
