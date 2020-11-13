package br.com.mind5.masterData.countrySearch.model.action;

import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountarchDaoSelect extends ActionStdTemplate<CountarchInfo> {

	public StdCountarchDaoSelect(DeciTreeOption<CountarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CountarchInfo> buildVisitorHook(DeciTreeOption<CountarchInfo> option) {
		return new VisiCountarchDaoSelect(option);
	}
}
