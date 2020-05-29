package br.com.mind5.business.scheduleYearData.model.action;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedyeratMergeToSelect extends ActionStdTemplateV2<SchedyeratInfo> {

	public StdSchedyeratMergeToSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedyeratInfo> buildVisitorHook(DeciTreeOption<SchedyeratInfo> option) {
		return new VisiSchedyeratMergeToSelect(option);
	}
}
