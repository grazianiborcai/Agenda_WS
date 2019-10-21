package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineSetterStatus;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedineEnforceStatus extends ActionVisitorTemplateEnforce<SchedineInfo> {
	
	@Override protected SchedineInfo enforceHook(SchedineInfo recordInfo) {
		InfoSetter<SchedineInfo> setter = new SchedineSetterStatus();
		return setter.setAttr(recordInfo);
	}
}
