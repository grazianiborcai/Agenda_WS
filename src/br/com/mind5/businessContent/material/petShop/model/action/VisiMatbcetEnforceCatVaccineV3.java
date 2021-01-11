package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.info.MatbcetSetterCatVaccineV3;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatbcetEnforceCatVaccineV3 extends ActionVisitorTemplateEnforce<MatbcetInfo> {
	
	public VisiMatbcetEnforceCatVaccineV3(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatbcetInfo enforceHook(MatbcetInfo recordInfo) {
		InfoSetter<MatbcetInfo> attrSetter = new MatbcetSetterCatVaccineV3();
		return attrSetter.setAttr(recordInfo);
	}
}
