package br.com.mind5.business.scheduleMonthData.model.action;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedonthatDaoSelect extends ActionStdTemplateV2<SchedonthatInfo> {

	public StdSchedonthatDaoSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedonthatInfo> buildVisitorHook(DeciTreeOption<SchedonthatInfo> option) {
		return new VisiSchedonthatDaoSelect(option);
	}
}
