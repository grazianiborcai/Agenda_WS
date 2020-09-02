package br.com.mind5.business.calendarCatalogueData.model.action;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalguataPruneAged extends ActionStdTemplateV2<CalguataInfo> {

	public StdCalguataPruneAged(DeciTreeOption<CalguataInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalguataInfo> buildVisitorHook(DeciTreeOption<CalguataInfo> option) {
		return new VisiCalguataPruneAged(option);
	}
}