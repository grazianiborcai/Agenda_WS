package br.com.mind5.masterData.stateSearch.model;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.decisionTree.StatarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StatarchModelSelect extends ModelTemplate<StatarchInfo> {

	public StatarchModelSelect(StatarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StatarchInfo> getDecisionTreeHook(DeciTreeOption<StatarchInfo> option) {
		return new StatarchRootSelect(option);
	}
}
