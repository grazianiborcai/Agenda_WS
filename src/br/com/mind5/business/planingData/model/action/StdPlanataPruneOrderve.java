package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanataPruneOrderve extends ActionStdTemplate<PlanataInfo> {

	public StdPlanataPruneOrderve(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PlanataInfo> buildVisitorHook(DeciTreeOption<PlanataInfo> option) {
		return new VisiPlanataPruneOrderve(option);
	}
}
