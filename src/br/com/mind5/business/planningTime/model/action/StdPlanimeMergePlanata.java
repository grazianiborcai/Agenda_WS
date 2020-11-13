package br.com.mind5.business.planningTime.model.action;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanimeMergePlanata extends ActionStdTemplate<PlanimeInfo> {

	public StdPlanimeMergePlanata(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PlanimeInfo> buildVisitorHook(DeciTreeOption<PlanimeInfo> option) {
		return new VisiPlanimeMergePlanata(option);
	}
}
