package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchSetterUser;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiEnforceUser extends ActionVisitorTemplateEnforce<PetarchInfo> {
	
	public PetarchVisiEnforceUser(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetarchInfo enforceHook(PetarchInfo recordInfo) {
		InfoSetter<PetarchInfo> attrSetter = new PetarchSetterUser();
		return attrSetter.setAttr(recordInfo);
	}
}
