package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchSetterPetUser;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiEnforcePetUser extends ActionVisitorTemplateEnforce<PetarchInfo> {
	
	public PetarchVisiEnforcePetUser(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetarchInfo enforceHook(PetarchInfo recordInfo) {
		InfoSetter<PetarchInfo> attrSetter = new PetarchSetterPetUser();
		return attrSetter.setAttr(recordInfo);
	}
}
