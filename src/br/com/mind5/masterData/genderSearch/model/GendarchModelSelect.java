package br.com.mind5.masterData.genderSearch.model;

import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.masterData.genderSearch.model.decisionTree.RootGendarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GendarchModelSelect extends ModelTemplate<GendarchInfo> {

	public GendarchModelSelect(GendarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<GendarchInfo> getDecisionTreeHook(DeciTreeOption<GendarchInfo> option) {
		return new RootGendarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
