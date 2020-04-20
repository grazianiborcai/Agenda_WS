package br.com.mind5.masterData.countrySearch.model;

import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.masterData.countrySearch.model.decisionTree.RootCountarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountarchModelSelect extends ModelTemplate<CountarchInfo> {

	public CountarchModelSelect(CountarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CountarchInfo> getDecisionTreeHook(DeciTreeOption<CountarchInfo> option) {
		return new RootCountarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
