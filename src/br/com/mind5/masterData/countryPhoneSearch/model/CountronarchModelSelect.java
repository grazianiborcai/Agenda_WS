package br.com.mind5.masterData.countryPhoneSearch.model;

import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.masterData.countryPhoneSearch.model.decisionTree.RootCountronarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountronarchModelSelect extends ModelTemplate<CountronarchInfo> {

	public CountronarchModelSelect(CountronarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CountronarchInfo> getDecisionTreeHook(DeciTreeOption<CountronarchInfo> option) {
		return new RootCountronarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
