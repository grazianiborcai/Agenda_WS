package br.com.mind5.masterData.countryPhoneSearch.model.action;

import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountronarchDaoSelect extends ActionStdTemplateV2<CountronarchInfo> {

	public StdCountronarchDaoSelect(DeciTreeOption<CountronarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CountronarchInfo> buildVisitorHook(DeciTreeOption<CountronarchInfo> option) {
		return new VisiCountronarchDaoSelect(option);
	}
}
