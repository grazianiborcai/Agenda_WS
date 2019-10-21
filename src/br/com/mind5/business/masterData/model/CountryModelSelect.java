package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryModelSelect extends ModelTemplate<CountryInfo> {

	public CountryModelSelect(CountryInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CountryInfo> getDecisionTreeHook(DeciTreeOption<CountryInfo> option) {
		return new RootCountrySelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
