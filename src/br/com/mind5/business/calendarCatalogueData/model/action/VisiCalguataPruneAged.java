package br.com.mind5.business.calendarCatalogueData.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarCatalogueData.info.CalguataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalguataPruneAged extends ActionVisitorTemplatePruneSelf<CalguataInfo> {
	
	public VisiCalguataPruneAged(DeciTreeOption<CalguataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<CalguataInfo> pruneHook(List<CalguataInfo> recordInfos) {	
		return CalguataPruner.pruneAged(recordInfos);
	}
}
