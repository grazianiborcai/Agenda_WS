package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPlanataEnforceWeekday extends ActionVisitorTemplateEnforce<PlanataInfo> {
	
	@Override protected PlanataInfo enforceHook(PlanataInfo recordInfo) {
		InfoSetter<PlanataInfo> attrSetter = new PlanataSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
