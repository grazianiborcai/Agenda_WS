package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
