package br.com.gda.business.planningTime_.model.action;

import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.info.PlanSetterCodWeekday;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPlanEnforceCodWeekday extends ActionVisitorTemplateEnforce<PlanInfo> {
	
	@Override protected PlanInfo enforceHook(PlanInfo recordInfo) {
		InfoSetter<PlanInfo> attrSetter = new PlanSetterCodWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
