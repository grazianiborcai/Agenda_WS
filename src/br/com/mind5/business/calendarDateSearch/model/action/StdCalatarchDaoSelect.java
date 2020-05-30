package br.com.mind5.business.calendarDateSearch.model.action;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalatarchDaoSelect extends ActionStdTemplateV2<CalatarchInfo> {

	public StdCalatarchDaoSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalatarchInfo> buildVisitorHook(DeciTreeOption<CalatarchInfo> option) {
		return new VisiCalatarchDaoSelect(option);
	}
}
