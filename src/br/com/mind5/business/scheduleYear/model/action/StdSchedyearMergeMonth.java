package br.com.mind5.business.scheduleYear.model.action;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdSchedyearMergeMonth extends ActionStdTemplateV2<SchedyearInfo> {

	public StdSchedyearMergeMonth(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedyearInfo> buildVisitorHook(DeciTreeOption<SchedyearInfo> option) {
		return new VisiSchedyearMergeMonth(option);
	}
}
