package br.com.mind5.business.pet.model.action;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetEnforceLChanged extends ActionVisitorTemplateEnforce<PetInfo> {
	
	public VisiPetEnforceLChanged(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetInfo enforceHook(PetInfo recordInfo) {
		InfoSetter<PetInfo> attrSetter = new PetSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
