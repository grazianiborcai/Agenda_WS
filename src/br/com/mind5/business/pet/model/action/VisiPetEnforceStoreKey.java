package br.com.mind5.business.pet.model.action;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetEnforceStoreKey extends ActionVisitorTemplateEnforce<PetInfo> {
	
	public VisiPetEnforceStoreKey(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetInfo enforceHook(PetInfo recordInfo) {
		InfoSetter<PetInfo> attrSetter = new PetSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
