package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountryLegalSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
