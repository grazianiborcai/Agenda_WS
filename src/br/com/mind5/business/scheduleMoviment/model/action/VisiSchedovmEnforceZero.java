package br.com.mind5.business.scheduleMoviment.model.action;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.info.SchedovmSetterZero;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedovmEnforceZero extends ActionVisitorTemplateEnforce<SchedovmInfo> {
	
	@Override protected SchedovmInfo enforceHook(SchedovmInfo recordInfo) {
		InfoSetter<SchedovmInfo> setter = new SchedovmSetterZero();
		return setter.setAttr(recordInfo);
	}
}
