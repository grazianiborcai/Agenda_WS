package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchSetterPetCus;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiEnforcePetCus extends ActionVisitorTemplateEnforce<PetarchInfo> {
	
	public PetarchVisiEnforcePetCus(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetarchInfo enforceHook(PetarchInfo recordInfo) {
		InfoSetter<PetarchInfo> attrSetter = new PetarchSetterPetCus();
		return attrSetter.setAttr(recordInfo);
	}
}
