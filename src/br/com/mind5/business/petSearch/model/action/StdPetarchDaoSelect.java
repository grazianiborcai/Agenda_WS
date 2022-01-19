package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetarchDaoSelect extends ActionStdTemplate<PetarchInfo> {

	public StdPetarchDaoSelect(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetarchInfo> buildVisitorHook(DeciTreeOption<PetarchInfo> option) {
		return new VisiPerarchDaoSelect(option);
	}
}
