package br.com.gda.business.materialStock.model.action;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.info.MatockSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatockEnforceKey extends ActionVisitorTemplateEnforce<MatockInfo> {
	
	@Override protected MatockInfo enforceHook(MatockInfo recordInfo) {
		InfoSetter<MatockInfo> attrSetter = new MatockSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
