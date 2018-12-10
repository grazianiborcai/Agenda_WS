package br.com.gda.business.snapshot.model.action;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.info.SnapSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiSnapEnforceLChanged extends ActionVisitorTemplateEnforce<SnapInfo> {
	
	@Override protected SnapInfo enforceHook(SnapInfo recordInfo) {
		InfoSetter<SnapInfo> attrSetter = new SnapSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
