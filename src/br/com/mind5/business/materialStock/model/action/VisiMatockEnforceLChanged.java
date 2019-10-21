package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.info.MatockSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatockEnforceLChanged extends ActionVisitorTemplateEnforce<MatockInfo> {
	
	@Override protected MatockInfo enforceHook(MatockInfo recordInfo) {
		InfoSetter<MatockInfo> attrSetter = new MatockSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
