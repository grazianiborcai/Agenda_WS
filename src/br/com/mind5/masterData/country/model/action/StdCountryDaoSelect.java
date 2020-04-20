package br.com.mind5.masterData.country.model.action;

import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountryDaoSelect extends ActionStdTemplateV2<CountryInfo> {

	public StdCountryDaoSelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CountryInfo> buildVisitorHook(DeciTreeOption<CountryInfo> option) {
		return new VisiCountryDaoSelect(option);
	}
}
