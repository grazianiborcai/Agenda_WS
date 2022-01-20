package br.com.mind5.business.pet.model.action;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetSetterUserKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetEnforceUserKey extends ActionVisitorTemplateEnforce<PetInfo> {
	
	public VisiPetEnforceUserKey(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetInfo enforceHook(PetInfo recordInfo) {
		InfoSetter<PetInfo> attrSetter = new PetSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
