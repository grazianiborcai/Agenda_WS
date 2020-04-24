package br.com.mind5.business.planingDataSearch.model.action;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanarchPruneSel extends ActionStdTemplateV2<PlanarchInfo> {

	public StdPlanarchPruneSel(DeciTreeOption<PlanarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PlanarchInfo> buildVisitorHook(DeciTreeOption<PlanarchInfo> option) {
		return new VisiPlanarchPruneSel(option);
	}
}
