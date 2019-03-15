package br.com.gda.business.storeLeaveDate.model.action;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStolevateEnforceLChanged extends ActionVisitorTemplateEnforce<StolevateInfo> {
	
	@Override protected StolevateInfo enforceHook(StolevateInfo recordInfo) {
		InfoSetter<StolevateInfo> attrSetter = new StolevateSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
