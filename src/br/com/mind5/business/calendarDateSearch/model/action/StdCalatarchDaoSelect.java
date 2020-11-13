package br.com.mind5.business.calendarDateSearch.model.action;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalatarchDaoSelect extends ActionStdTemplate<CalatarchInfo> {

	public StdCalatarchDaoSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalatarchInfo> buildVisitorHook(DeciTreeOption<CalatarchInfo> option) {
		return new VisiCalatarchDaoSelect(option);
	}
}
