package br.com.mind5.business.storeProspect.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.decisionTree.StoprosRootInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosModelInsert extends ModelTemplate<StoprosInfo> {

	public StoprosModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StoprosInfo.class);
	}
	
	
	
	@Override protected DeciTree<StoprosInfo> getDecisionTreeHook(DeciTreeOption<StoprosInfo> option) {
		return new StoprosRootInsert(option);
	}
}
