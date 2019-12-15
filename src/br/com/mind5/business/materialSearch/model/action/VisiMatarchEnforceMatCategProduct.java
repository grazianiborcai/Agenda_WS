package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchSetterMatCategProduct;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatarchEnforceMatCategProduct extends ActionVisitorTemplateEnforce<MatarchInfo> {
	
	@Override protected MatarchInfo enforceHook(MatarchInfo recordInfo) {
		InfoSetter<MatarchInfo> attrSetter = new MatarchSetterMatCategProduct();
		return attrSetter.setAttr(recordInfo);
	}
}
