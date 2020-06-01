package br.com.mind5.business.calendarTimeStore.model.action;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreSetterFallback;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalimoreEnforceFallback extends ActionVisitorTemplateEnforceV2<CalimoreInfo> {
	
	public VisiCalimoreEnforceFallback(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}

	
	
	@Override protected CalimoreInfo enforceHook(CalimoreInfo recordInfo) {
		InfoSetter<CalimoreInfo> attrSetter = new CalimoreSetterFallback();
		return attrSetter.setAttr(recordInfo);
	}
}
