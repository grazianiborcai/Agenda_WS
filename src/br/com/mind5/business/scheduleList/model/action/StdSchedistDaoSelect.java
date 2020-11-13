package br.com.mind5.business.scheduleList.model.action;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedistDaoSelect extends ActionStdTemplate<SchedistInfo> {

	public StdSchedistDaoSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedistInfo> buildVisitorHook(DeciTreeOption<SchedistInfo> option) {
		return new VisiSchedistDaoSelect(option);
	}
}
