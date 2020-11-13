package br.com.mind5.business.scheduleWeekData.model.action;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedeekdatDaoSelect extends ActionStdTemplate<SchedeekdatInfo> {

	public StdSchedeekdatDaoSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedeekdatInfo> buildVisitorHook(DeciTreeOption<SchedeekdatInfo> option) {
		return new VisiSchedeekdatDaoSelect(option);
	}
}
