package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.info.MatbcetSetterCatHaircutScissor;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatbcetEnforceCatHaircutScissor extends ActionVisitorTemplateEnforce<MatbcetInfo> {
	
	public VisiMatbcetEnforceCatHaircutScissor(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatbcetInfo enforceHook(MatbcetInfo recordInfo) {
		InfoSetter<MatbcetInfo> attrSetter = new MatbcetSetterCatHaircutScissor();
		return attrSetter.setAttr(recordInfo);
	}
}
