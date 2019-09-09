package br.com.gda.business.scheduleWeekData.model.action;

import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatSetterWeekday;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedeekdatEnforceWeekday extends ActionVisitorTemplateEnforce<SchedeekdatInfo> {
	
	@Override protected SchedeekdatInfo enforceHook(SchedeekdatInfo recordInfo) {
		InfoSetter<SchedeekdatInfo> attrSetter = new SchedeekdatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
