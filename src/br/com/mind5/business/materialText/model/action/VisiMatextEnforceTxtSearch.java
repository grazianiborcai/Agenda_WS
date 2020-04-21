package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextSetterTxtSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextEnforceTxtSearch extends ActionVisitorTemplateEnforceV2<MatextInfo> {
	
	public VisiMatextEnforceTxtSearch(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterTxtSearch();
		return attrSetter.setAttr(recordInfo);
	}
}
