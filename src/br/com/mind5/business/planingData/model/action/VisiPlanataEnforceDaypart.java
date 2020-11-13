package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataSetterDaypart;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataEnforceDaypart extends ActionVisitorTemplateEnforce<PlanataInfo> {
	
	public VisiPlanataEnforceDaypart(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PlanataInfo enforceHook(PlanataInfo recordInfo) {
		InfoSetter<PlanataInfo> attrSetter = new PlanataSetterDaypart();
		return attrSetter.setAttr(recordInfo);
	}
}
