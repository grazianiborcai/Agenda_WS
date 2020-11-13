package br.com.mind5.business.calendarDateAvailability.model.action;

import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalatityMergeCalate extends ActionStdTemplate<CalatityInfo> {

	public StdCalatityMergeCalate(DeciTreeOption<CalatityInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalatityInfo> buildVisitorHook(DeciTreeOption<CalatityInfo> option) {
		return new VisiCalatityMergeCalate(option);
	}
}
