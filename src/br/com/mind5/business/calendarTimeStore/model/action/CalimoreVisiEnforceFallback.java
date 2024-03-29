package br.com.mind5.business.calendarTimeStore.model.action;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreSetterFallback;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimoreVisiEnforceFallback extends ActionVisitorTemplateEnforce<CalimoreInfo> {
	
	public CalimoreVisiEnforceFallback(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}

	
	
	@Override protected CalimoreInfo enforceHook(CalimoreInfo recordInfo) {
		InfoSetter<CalimoreInfo> attrSetter = new CalimoreSetterFallback();
		return attrSetter.setAttr(recordInfo);
	}
}
