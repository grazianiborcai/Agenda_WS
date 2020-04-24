package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataEnforceWeekday extends ActionVisitorTemplateEnforceV2<PlanataInfo> {
	
	public VisiPlanataEnforceWeekday(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PlanataInfo enforceHook(PlanataInfo recordInfo) {
		InfoSetter<PlanataInfo> attrSetter = new PlanataSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
