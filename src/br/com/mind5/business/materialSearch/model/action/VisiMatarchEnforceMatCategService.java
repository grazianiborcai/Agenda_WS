package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchSetterMatCategService;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiMatarchEnforceMatCategService extends ActionVisitorTemplateEnforceV1<MatarchInfo> {
	
	@Override protected MatarchInfo enforceHook(MatarchInfo recordInfo) {
		InfoSetter<MatarchInfo> attrSetter = new MatarchSetterMatCategService();
		return attrSetter.setAttr(recordInfo);
	}
}
