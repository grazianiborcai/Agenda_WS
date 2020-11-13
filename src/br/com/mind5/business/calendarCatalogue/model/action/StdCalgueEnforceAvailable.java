package br.com.mind5.business.calendarCatalogue.model.action;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalgueEnforceAvailable extends ActionStdTemplate<CalgueInfo> {

	public StdCalgueEnforceAvailable(DeciTreeOption<CalgueInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalgueInfo> buildVisitorHook(DeciTreeOption<CalgueInfo> option) {
		return new VisiCalgueEnforceAvailable(option);
	}
}
