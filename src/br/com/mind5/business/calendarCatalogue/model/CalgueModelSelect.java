package br.com.mind5.business.calendarCatalogue.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.model.decisionTree.RootCalgueSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalgueModelSelect extends ModelTemplate<CalgueInfo> {

	public CalgueModelSelect(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CalgueInfo.class);
	}
	
	
	
	@Override protected DeciTree<CalgueInfo> getDecisionTreeHook(DeciTreeOption<CalgueInfo> option) {
		return new RootCalgueSelect(option);
	}
}
