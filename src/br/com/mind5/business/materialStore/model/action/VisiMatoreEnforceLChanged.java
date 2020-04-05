package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiMatoreEnforceLChanged extends ActionVisitorTemplateEnforceV1<MatoreInfo> {
	
	@Override protected MatoreInfo enforceHook(MatoreInfo recordInfo) {
		InfoSetter<MatoreInfo> attrSetter = new MatoreSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
