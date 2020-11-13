package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.info.MatbcetSetterCatHaircut;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatbcetEnforceCatHaircut extends ActionVisitorTemplateEnforce<MatbcetInfo> {
	
	public VisiMatbcetEnforceCatHaircut(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatbcetInfo enforceHook(MatbcetInfo recordInfo) {
		InfoSetter<MatbcetInfo> attrSetter = new MatbcetSetterCatHaircut();
		return attrSetter.setAttr(recordInfo);
	}
}
