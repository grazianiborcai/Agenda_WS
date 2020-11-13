package br.com.mind5.business.calendarDateSearch.model.action;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalatarchMergeToSelect extends ActionStdTemplate<CalatarchInfo> {

	public StdCalatarchMergeToSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalatarchInfo> buildVisitorHook(DeciTreeOption<CalatarchInfo> option) {
		return new VisiCalatarchMergeToSelect(option);
	}
}
