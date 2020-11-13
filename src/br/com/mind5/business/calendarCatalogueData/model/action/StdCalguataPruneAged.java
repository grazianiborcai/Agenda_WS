package br.com.mind5.business.calendarCatalogueData.model.action;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalguataPruneAged extends ActionStdTemplate<CalguataInfo> {

	public StdCalguataPruneAged(DeciTreeOption<CalguataInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalguataInfo> buildVisitorHook(DeciTreeOption<CalguataInfo> option) {
		return new VisiCalguataPruneAged(option);
	}
}
