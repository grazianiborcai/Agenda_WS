package br.com.mind5.business.planningTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.model.decisionTree.PlanimeRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanimeModelSelect extends ModelTemplate<PlanimeInfo> {	
	
	public PlanimeModelSelect(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PlanimeInfo.class);
	}
	
	
	
	@Override protected DeciTree<PlanimeInfo> getDecisionTreeHook(DeciTreeOption<PlanimeInfo> option) {
		return new PlanimeRootSelect(option);
	}
}
