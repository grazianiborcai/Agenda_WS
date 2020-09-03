package br.com.mind5.business.calendarCatalogue.model.action;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalgueMergeWeekday extends ActionStdTemplateV2<CalgueInfo> {

	public StdCalgueMergeWeekday(DeciTreeOption<CalgueInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalgueInfo> buildVisitorHook(DeciTreeOption<CalgueInfo> option) {
		return new VisiCalgueMergeWeekday(option);
	}
}
