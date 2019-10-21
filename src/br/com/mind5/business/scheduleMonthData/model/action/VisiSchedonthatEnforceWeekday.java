package br.com.mind5.business.scheduleMonthData.model.action;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedonthatEnforceWeekday extends ActionVisitorTemplateEnforce<SchedonthatInfo> {
	
	@Override protected SchedonthatInfo enforceHook(SchedonthatInfo recordInfo) {
		InfoSetter<SchedonthatInfo> attrSetter = new SchedonthatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
