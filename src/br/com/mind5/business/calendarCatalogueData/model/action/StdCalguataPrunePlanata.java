package br.com.mind5.business.calendarCatalogueData.model.action;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalguataPrunePlanata extends ActionStdTemplateV2<CalguataInfo> {

	public StdCalguataPrunePlanata(DeciTreeOption<CalguataInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalguataInfo> buildVisitorHook(DeciTreeOption<CalguataInfo> option) {
		return new VisiCalguataPrunePlanata(option);
	}
}
