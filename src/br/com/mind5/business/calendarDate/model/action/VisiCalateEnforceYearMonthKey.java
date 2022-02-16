package br.com.mind5.business.calendarDate.model.action;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateSetterYearMonthKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalateEnforceYearMonthKey extends ActionVisitorTemplateEnforce<CalateInfo> {
	
	public VisiCalateEnforceYearMonthKey(DeciTreeOption<CalateInfo> option) {
		super(option);
	}

	
	
	@Override protected CalateInfo enforceHook(CalateInfo recordInfo) {
		InfoSetter<CalateInfo> attrSetter = new CalateSetterYearMonthKey();
		return attrSetter.setAttr(recordInfo);
	}
}
