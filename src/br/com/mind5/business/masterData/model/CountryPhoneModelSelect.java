package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountryPhoneSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryPhoneModelSelect extends ModelTemplate<CountryPhoneInfo> {

	public CountryPhoneModelSelect(CountryPhoneInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CountryPhoneInfo> getDecisionTreeHook(DeciTreeOption<CountryPhoneInfo> option) {
		return new RootCountryPhoneSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
