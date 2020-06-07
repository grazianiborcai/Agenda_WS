package br.com.mind5.business.calendarTimeEmployee.model.action;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalimempMergeCalate extends ActionStdTemplateV2<CalimempInfo> {

	public StdCalimempMergeCalate(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalimempInfo> buildVisitorHook(DeciTreeOption<CalimempInfo> option) {
		return new VisiCalimempMergeCalate(option);
	}
}
