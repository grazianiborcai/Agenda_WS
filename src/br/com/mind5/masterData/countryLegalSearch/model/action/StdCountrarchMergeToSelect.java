package br.com.mind5.masterData.countryLegalSearch.model.action;

import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountrarchMergeToSelect extends ActionStdTemplateV2<CountrarchInfo> {
	
	public StdCountrarchMergeToSelect(DeciTreeOption<CountrarchInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CountrarchInfo> buildVisitorHook(DeciTreeOption<CountrarchInfo> option) {
		return new VisiCountrarchMergeToSelect(option);
	}
}
