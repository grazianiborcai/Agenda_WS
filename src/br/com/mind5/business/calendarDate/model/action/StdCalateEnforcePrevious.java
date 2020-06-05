package br.com.mind5.business.calendarDate.model.action;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalateEnforcePrevious extends ActionStdTemplateV2<CalateInfo> {

	public StdCalateEnforcePrevious(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalateInfo> buildVisitorHook(DeciTreeOption<CalateInfo> option) {
		return new VisiCalateEnforcePrevious(option);
	}
}