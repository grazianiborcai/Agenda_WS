package br.com.mind5.business.calendarDateAvailability.model.action;

import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalatityMergeCalate extends ActionStdTemplateV2<CalatityInfo> {

	public StdCalatityMergeCalate(DeciTreeOption<CalatityInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalatityInfo> buildVisitorHook(DeciTreeOption<CalatityInfo> option) {
		return new VisiCalatityMergeCalate(option);
	}
}
