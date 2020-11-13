package br.com.mind5.business.scheduleWeek.model.action;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedeekMergeSchedeekdat extends ActionStdTemplate<SchedeekInfo> {

	public StdSchedeekMergeSchedeekdat(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedeekInfo> buildVisitorHook(DeciTreeOption<SchedeekInfo> option) {
		return new VisiSchedeekMergeSchedeekdat(option);
	}
}
