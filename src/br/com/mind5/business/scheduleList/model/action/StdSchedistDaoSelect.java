package br.com.mind5.business.scheduleList.model.action;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedistDaoSelect extends ActionStdTemplateV2<SchedistInfo> {

	public StdSchedistDaoSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedistInfo> buildVisitorHook(DeciTreeOption<SchedistInfo> option) {
		return new VisiSchedistDaoSelect(option);
	}
}
