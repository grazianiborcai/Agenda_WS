package br.com.mind5.business.scheduleDay.model.action;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedayMergePrevious extends ActionStdTemplateV2<SchedayInfo> {

	public StdSchedayMergePrevious(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedayInfo> buildVisitorHook(DeciTreeOption<SchedayInfo> option) {
		return new VisiSchedayMergePrevious(option);
	}
}
