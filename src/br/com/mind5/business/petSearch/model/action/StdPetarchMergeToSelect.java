package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetarchMergeToSelect extends ActionStdTemplate<PetarchInfo> {

	public StdPetarchMergeToSelect(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetarchInfo> buildVisitorHook(DeciTreeOption<PetarchInfo> option) {
		return new VisiPetarchMergeToSelect(option);
	}
}
