package br.com.mind5.masterData.countrySearch.model.action;

import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountarchDaoSelect extends ActionStdTemplateV2<CountarchInfo> {

	public StdCountarchDaoSelect(DeciTreeOption<CountarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CountarchInfo> buildVisitorHook(DeciTreeOption<CountarchInfo> option) {
		return new VisiCountarchDaoSelect(option);
	}
}
