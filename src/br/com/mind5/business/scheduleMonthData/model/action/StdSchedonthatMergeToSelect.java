package br.com.mind5.business.scheduleMonthData.model.action;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedonthatMergeToSelect extends ActionStdTemplate<SchedonthatInfo> {

	public StdSchedonthatMergeToSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedonthatInfo> buildVisitorHook(DeciTreeOption<SchedonthatInfo> option) {
		return new VisiSchedonthatMergeToSelect(option);
	}
}
