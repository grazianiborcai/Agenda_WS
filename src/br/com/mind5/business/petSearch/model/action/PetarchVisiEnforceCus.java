package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchSetterCus;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiEnforceCus extends ActionVisitorTemplateEnforce<PetarchInfo> {
	
	public PetarchVisiEnforceCus(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	

	@Override protected PetarchInfo enforceHook(PetarchInfo recordInfo) {
		InfoSetter<PetarchInfo> attrSetter = new PetarchSetterCus();
		return attrSetter.setAttr(recordInfo);
	}
}
