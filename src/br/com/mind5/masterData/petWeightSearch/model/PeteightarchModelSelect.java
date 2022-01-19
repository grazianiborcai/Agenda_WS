package br.com.mind5.masterData.petWeightSearch.model;

import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;
import br.com.mind5.masterData.petWeightSearch.model.decisionTree.RootPeteightarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeteightarchModelSelect extends ModelTemplate<PeteightarchInfo> {

	public PeteightarchModelSelect(PeteightarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PeteightarchInfo> getDecisionTreeHook(DeciTreeOption<PeteightarchInfo> option) {
		return new RootPeteightarchSelect(option);
	}
}
