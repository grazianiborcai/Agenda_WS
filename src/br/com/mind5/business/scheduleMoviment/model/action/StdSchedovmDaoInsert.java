package br.com.mind5.business.scheduleMoviment.model.action;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedovmDaoInsert extends ActionStdTemplate<SchedovmInfo> {

	public StdSchedovmDaoInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedovmInfo> buildVisitorHook(DeciTreeOption<SchedovmInfo> option) {
		return new VisiSchedovmDaoInsert(option);
	}
}
