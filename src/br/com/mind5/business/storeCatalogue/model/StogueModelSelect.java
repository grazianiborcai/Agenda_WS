package br.com.mind5.business.storeCatalogue.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.model.decisionTree.RootStogueSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StogueModelSelect extends ModelTemplate<StogueInfo> {

	public StogueModelSelect(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StogueInfo.class);
	}
	
	
	
	@Override protected DeciTree<StogueInfo> getDecisionTreeHook(DeciTreeOption<StogueInfo> option) {
		return new RootStogueSelect(option);
	}
}
