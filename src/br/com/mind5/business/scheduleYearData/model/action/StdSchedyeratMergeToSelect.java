package br.com.mind5.business.scheduleYearData.model.action;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedyeratMergeToSelect extends ActionStdTemplate<SchedyeratInfo> {

	public StdSchedyeratMergeToSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedyeratInfo> buildVisitorHook(DeciTreeOption<SchedyeratInfo> option) {
		return new VisiSchedyeratMergeToSelect(option);
	}
}
