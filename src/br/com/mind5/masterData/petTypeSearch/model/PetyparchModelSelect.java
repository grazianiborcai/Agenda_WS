package br.com.mind5.masterData.petTypeSearch.model;

import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;
import br.com.mind5.masterData.petTypeSearch.model.decisionTree.PetyparchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetyparchModelSelect extends ModelTemplate<PetyparchInfo> {

	public PetyparchModelSelect(PetyparchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PetyparchInfo> getDecisionTreeHook(DeciTreeOption<PetyparchInfo> option) {
		return new PetyparchRootSelect(option);
	}
}
