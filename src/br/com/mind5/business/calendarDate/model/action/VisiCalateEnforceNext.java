package br.com.mind5.business.calendarDate.model.action;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateSetterNext;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalateEnforceNext extends ActionVisitorTemplateEnforceV2<CalateInfo> {
	
	public VisiCalateEnforceNext(DeciTreeOption<CalateInfo> option) {
		super(option);
	}

	
	
	@Override protected CalateInfo enforceHook(CalateInfo recordInfo) {
		InfoSetter<CalateInfo> attrSetter = new CalateSetterNext();
		return attrSetter.setAttr(recordInfo);
	}
}
