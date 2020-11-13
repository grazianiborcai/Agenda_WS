package br.com.mind5.business.planningTime.model.action;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPlanimeMergeMatlis extends ActionStdTemplate<PlanimeInfo> {

	public StdPlanimeMergeMatlis(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PlanimeInfo> buildVisitorHook(DeciTreeOption<PlanimeInfo> option) {
		return new VisiPlanimeMergeMatlis(option);
	}
}
