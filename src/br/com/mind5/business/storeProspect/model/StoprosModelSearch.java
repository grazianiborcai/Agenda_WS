package br.com.mind5.business.storeProspect.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.decisionTree.RootStoprosSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosModelSearch extends ModelTemplate<StoprosInfo> {

	public StoprosModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StoprosInfo.class);
	}
	
	
	
	@Override protected DeciTree<StoprosInfo> getDecisionTreeHook(DeciTreeOption<StoprosInfo> option) {
		return new RootStoprosSearch(option);
	}
}
