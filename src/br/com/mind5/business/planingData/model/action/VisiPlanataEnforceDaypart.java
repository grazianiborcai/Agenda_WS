package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataSetterDaypart;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPlanataEnforceDaypart extends ActionVisitorTemplateEnforce<PlanataInfo> {
	
	@Override protected PlanataInfo enforceHook(PlanataInfo recordInfo) {
		InfoSetter<PlanataInfo> attrSetter = new PlanataSetterDaypart();
		return attrSetter.setAttr(recordInfo);
	}
}
