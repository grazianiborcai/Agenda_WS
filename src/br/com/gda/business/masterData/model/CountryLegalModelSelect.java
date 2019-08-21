package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountryLegalSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CountryLegalModelSelect extends ModelTemplate<CountryLegalInfo> {

	public CountryLegalModelSelect(CountryLegalInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CountryLegalInfo> getDecisionTreeHook(DeciTreeOption<CountryLegalInfo> option) {
		return new RootCountryLegalSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
