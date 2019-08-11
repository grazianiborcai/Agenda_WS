package br.com.gda.business.schedule.model.action;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.OrderemSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderemEnforceKey extends ActionVisitorTemplateEnforce<ScheduInfo> {
	
	@Override protected ScheduInfo enforceHook(ScheduInfo recordInfo) {
		InfoSetter<ScheduInfo> setter = new OrderemSetterKey();
		return setter.setAttr(recordInfo);
	}
}
