package br.com.mind5.masterData.countryPhoneSearch.model.action;

import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountronarchDaoSelect extends ActionStdTemplate<CountronarchInfo> {

	public StdCountronarchDaoSelect(DeciTreeOption<CountronarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CountronarchInfo> buildVisitorHook(DeciTreeOption<CountronarchInfo> option) {
		return new VisiCountronarchDaoSelect(option);
	}
}
