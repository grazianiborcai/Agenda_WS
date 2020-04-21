package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchSetterMatCategProduct;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatarchEnforceMatCategProduct extends ActionVisitorTemplateEnforceV2<MatarchInfo> {
	
	public VisiMatarchEnforceMatCategProduct(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatarchInfo enforceHook(MatarchInfo recordInfo) {
		InfoSetter<MatarchInfo> attrSetter = new MatarchSetterMatCategProduct();
		return attrSetter.setAttr(recordInfo);
	}
}
