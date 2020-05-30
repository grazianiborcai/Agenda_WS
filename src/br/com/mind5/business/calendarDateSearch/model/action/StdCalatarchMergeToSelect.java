package br.com.mind5.business.calendarDateSearch.model.action;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalatarchMergeToSelect extends ActionStdTemplateV2<CalatarchInfo> {

	public StdCalatarchMergeToSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalatarchInfo> buildVisitorHook(DeciTreeOption<CalatarchInfo> option) {
		return new VisiCalatarchMergeToSelect(option);
	}
}
