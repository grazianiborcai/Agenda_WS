package br.com.mind5.business.scheduleMonth.model.action;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedmonMergeCalate extends ActionStdTemplateV2<SchedmonInfo> {

	public StdSchedmonMergeCalate(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedmonInfo> buildVisitorHook(DeciTreeOption<SchedmonInfo> option) {
		return new VisiSchedmonMergeCalate(option);
	}
}
