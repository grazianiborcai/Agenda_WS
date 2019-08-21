package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountryPhoneSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
