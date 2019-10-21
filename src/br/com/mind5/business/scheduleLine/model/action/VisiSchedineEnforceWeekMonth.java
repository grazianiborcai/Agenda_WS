package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineSetterWeekMonth;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedineEnforceWeekMonth extends ActionVisitorTemplateEnforce<SchedineInfo> {
	
	@Override protected SchedineInfo enforceHook(SchedineInfo recordInfo) {
		InfoSetter<SchedineInfo> setter = new SchedineSetterWeekMonth();
		return setter.setAttr(recordInfo);
	}
}
