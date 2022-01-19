package br.com.mind5.business.petSearch.model.action;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchSuccess extends ActionStdSuccessTemplate<PetarchInfo> {
	
	public StdPerarchSuccess(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
}
