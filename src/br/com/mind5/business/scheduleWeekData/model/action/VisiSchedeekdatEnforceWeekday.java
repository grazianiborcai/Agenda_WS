package br.com.mind5.business.scheduleWeekData.model.action;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiSchedeekdatEnforceWeekday extends ActionVisitorTemplateEnforceV1<SchedeekdatInfo> {
	
	@Override protected SchedeekdatInfo enforceHook(SchedeekdatInfo recordInfo) {
		InfoSetter<SchedeekdatInfo> attrSetter = new SchedeekdatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
