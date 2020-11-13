package br.com.mind5.business.planingDataSearch.model.action;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanarchPruneSel extends ActionStdTemplate<PlanarchInfo> {

	public StdPlanarchPruneSel(DeciTreeOption<PlanarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PlanarchInfo> buildVisitorHook(DeciTreeOption<PlanarchInfo> option) {
		return new VisiPlanarchPruneSel(option);
	}
}
