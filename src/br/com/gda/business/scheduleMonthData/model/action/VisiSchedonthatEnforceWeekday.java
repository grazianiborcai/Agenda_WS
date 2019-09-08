package br.com.gda.business.scheduleMonthData.model.action;

import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.business.scheduleMonthData.info.SchedonthatSetterWeekday;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedonthatEnforceWeekday extends ActionVisitorTemplateEnforce<SchedonthatInfo> {
	
	@Override protected SchedonthatInfo enforceHook(SchedonthatInfo recordInfo) {
		InfoSetter<SchedonthatInfo> attrSetter = new SchedonthatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
