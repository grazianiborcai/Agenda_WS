package br.com.mind5.business.scheduleRange.model.action;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedageMergeToSelect extends ActionStdTemplate<SchedageInfo> {

	public StdSchedageMergeToSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedageInfo> buildVisitorHook(DeciTreeOption<SchedageInfo> option) {
		return new VisiSchedageMergeToSelect(option);
	}
}
