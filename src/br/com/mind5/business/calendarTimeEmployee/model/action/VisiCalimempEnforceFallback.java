package br.com.mind5.business.calendarTimeEmployee.model.action;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempSetterFallback;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalimempEnforceFallback extends ActionVisitorTemplateEnforce<CalimempInfo> {
	
	public VisiCalimempEnforceFallback(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}

	
	
	@Override protected CalimempInfo enforceHook(CalimempInfo recordInfo) {
		InfoSetter<CalimempInfo> attrSetter = new CalimempSetterFallback();
		return attrSetter.setAttr(recordInfo);
	}
}
