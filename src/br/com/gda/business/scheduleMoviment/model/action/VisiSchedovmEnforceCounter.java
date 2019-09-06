package br.com.gda.business.scheduleMoviment.model.action;

import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.business.scheduleMoviment.info.SchedovmSetterCounter;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedovmEnforceCounter extends ActionVisitorTemplateEnforce<SchedovmInfo> {
	
	@Override protected SchedovmInfo enforceHook(SchedovmInfo recordInfo) {
		InfoSetter<SchedovmInfo> setter = new SchedovmSetterCounter();
		return setter.setAttr(recordInfo);
	}
}
