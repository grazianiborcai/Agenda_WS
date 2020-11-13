package br.com.mind5.business.calendarWeekYear.model.action;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCaleekyDaoSelect extends ActionStdTemplate<CaleekyInfo> {

	public StdCaleekyDaoSelect(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CaleekyInfo> buildVisitorHook(DeciTreeOption<CaleekyInfo> option) {
		return new VisiCaleekyDaoSelect(option);
	}
}
