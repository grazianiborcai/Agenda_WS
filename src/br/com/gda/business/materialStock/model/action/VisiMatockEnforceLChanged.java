package br.com.gda.business.materialStock.model.action;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.info.MatockSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatockEnforceLChanged extends ActionVisitorTemplateEnforce<MatockInfo> {
	
	@Override protected MatockInfo enforceHook(MatockInfo recordInfo) {
		InfoSetter<MatockInfo> attrSetter = new MatockSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
