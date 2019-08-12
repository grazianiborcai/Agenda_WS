package br.com.gda.business.scheduleLine.model.action;

import br.com.gda.business.scheduleLine.info.OrderemSetterKey;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderemEnforceKey extends ActionVisitorTemplateEnforce<SchedineInfo> {
	
	@Override protected SchedineInfo enforceHook(SchedineInfo recordInfo) {
		InfoSetter<SchedineInfo> setter = new OrderemSetterKey();
		return setter.setAttr(recordInfo);
	}
}
