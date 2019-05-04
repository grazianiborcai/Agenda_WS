package br.com.gda.business.planingData.model.action;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataSetterWeekday;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPlanataEnforceWeekday extends ActionVisitorTemplateEnforce<PlanataInfo> {
	
	@Override protected PlanataInfo enforceHook(PlanataInfo recordInfo) {
		InfoSetter<PlanataInfo> attrSetter = new PlanataSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
