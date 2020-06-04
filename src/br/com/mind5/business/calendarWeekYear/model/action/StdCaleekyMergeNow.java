package br.com.mind5.business.calendarWeekYear.model.action;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCaleekyMergeNow extends ActionStdTemplateV2<CaleekyInfo> {

	public StdCaleekyMergeNow(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CaleekyInfo> buildVisitorHook(DeciTreeOption<CaleekyInfo> option) {
		return new VisiCaleekyMergeNow(option);
	}
}
