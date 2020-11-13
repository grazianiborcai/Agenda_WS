package br.com.mind5.business.calendarDate.model.action;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdCalateMergeMooncal extends ActionStdTemplate<CalateInfo> {

	public StdCalateMergeMooncal(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalateInfo> buildVisitorHook(DeciTreeOption<CalateInfo> option) {
		return new VisiCalateMergeMooncal(option);
	}
}
