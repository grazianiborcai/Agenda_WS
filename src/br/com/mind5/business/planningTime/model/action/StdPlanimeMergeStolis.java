package br.com.mind5.business.planningTime.model.action;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPlanimeMergeStolis extends ActionStdTemplateV2<PlanimeInfo> {

	public StdPlanimeMergeStolis(DeciTreeOption<PlanimeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PlanimeInfo> buildVisitorHook(DeciTreeOption<PlanimeInfo> option) {
		return new VisiPlanimeMergeStolis(option);
	}
}
