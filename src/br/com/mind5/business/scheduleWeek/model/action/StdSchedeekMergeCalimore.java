package br.com.mind5.business.scheduleWeek.model.action;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdSchedeekMergeCalimore extends ActionStdTemplate<SchedeekInfo> {

	public StdSchedeekMergeCalimore(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedeekInfo> buildVisitorHook(DeciTreeOption<SchedeekInfo> option) {
		return new VisiSchedeekMergeCalimore(option);
	}
}
