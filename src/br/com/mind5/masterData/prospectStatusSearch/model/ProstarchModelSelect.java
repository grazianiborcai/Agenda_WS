package br.com.mind5.masterData.prospectStatusSearch.model;

import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.masterData.prospectStatusSearch.model.decisionTree.ProstarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ProstarchModelSelect extends ModelTemplate<ProstarchInfo> {

	public ProstarchModelSelect(ProstarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<ProstarchInfo> getDecisionTreeHook(DeciTreeOption<ProstarchInfo> option) {
		return new ProstarchRootSelect(option);
	}
}
