package br.com.mind5.masterData.countryLegalSearch.model.action;

import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountrarchDaoSelect extends ActionStdTemplate<CountrarchInfo> {

	public StdCountrarchDaoSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CountrarchInfo> buildVisitorHook(DeciTreeOption<CountrarchInfo> option) {
		return new VisiCountrarchDaoSelect(option);
	}
}
