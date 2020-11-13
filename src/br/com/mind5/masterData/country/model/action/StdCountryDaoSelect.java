package br.com.mind5.masterData.country.model.action;

import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountryDaoSelect extends ActionStdTemplate<CountryInfo> {

	public StdCountryDaoSelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CountryInfo> buildVisitorHook(DeciTreeOption<CountryInfo> option) {
		return new VisiCountryDaoSelect(option);
	}
}
