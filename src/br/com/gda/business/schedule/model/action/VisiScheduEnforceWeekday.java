package br.com.gda.business.schedule.model.action;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.ScheduSetterWeekday;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiScheduEnforceWeekday extends ActionVisitorTemplateEnforce<ScheduInfo> {
	
	@Override protected ScheduInfo enforceHook(ScheduInfo recordInfo) {
		InfoSetter<ScheduInfo> setter = new ScheduSetterWeekday();
		return setter.setAttr(recordInfo);
	}
}
