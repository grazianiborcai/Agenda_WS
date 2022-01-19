package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchSetterCus;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetarchEnforceCus extends ActionVisitorTemplateEnforce<PetarchInfo> {
	
	public VisiPetarchEnforceCus(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	

	@Override protected PetarchInfo enforceHook(PetarchInfo recordInfo) {
		InfoSetter<PetarchInfo> attrSetter = new PetarchSetterCus();
		return attrSetter.setAttr(recordInfo);
	}
}
