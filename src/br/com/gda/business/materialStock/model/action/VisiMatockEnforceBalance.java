package br.com.gda.business.materialStock.model.action;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.info.MatockSetterBalance;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatockEnforceBalance extends ActionVisitorTemplateEnforce<MatockInfo> {
	
	@Override protected MatockInfo enforceHook(MatockInfo recordInfo) {
		InfoSetter<MatockInfo> attrSetter = new MatockSetterBalance();
		return attrSetter.setAttr(recordInfo);
	}
}
