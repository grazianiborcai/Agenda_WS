package br.com.gda.business.feeDefault.model.action;

import br.com.gda.business.feeDefault.info.FeedefSetterCategServ;
import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFeedefEnforceCategServ extends ActionVisitorTemplateEnforce<FeedefInfo> {
	
	@Override protected FeedefInfo enforceHook(FeedefInfo recordInfo) {
		InfoSetter<FeedefInfo> setter = new FeedefSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
