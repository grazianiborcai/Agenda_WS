package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanataEnforceDaypart extends ActionStdTemplateV2<PlanataInfo> {

	public StdPlanataEnforceDaypart(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PlanataInfo> buildVisitorHook(DeciTreeOption<PlanataInfo> option) {
		return new VisiPlanataEnforceDaypart(option);
	}
}
