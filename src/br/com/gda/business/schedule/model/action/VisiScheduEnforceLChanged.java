package br.com.gda.business.schedule.model.action;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.ScheduSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiScheduEnforceLChanged extends ActionVisitorTemplateEnforce<ScheduInfo> {
	
	@Override protected ScheduInfo enforceHook(ScheduInfo recordInfo) {
		InfoSetter<ScheduInfo> setter = new ScheduSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
