package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineSetterOrderKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSchedineEnforceOrderKey extends ActionVisitorTemplateEnforce<SchedineInfo> {
	
	@Override protected SchedineInfo enforceHook(SchedineInfo recordInfo) {
		InfoSetter<SchedineInfo> setter = new SchedineSetterOrderKey();
		return setter.setAttr(recordInfo);
	}
}
