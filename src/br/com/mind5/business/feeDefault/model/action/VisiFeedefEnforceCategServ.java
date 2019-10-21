package br.com.mind5.business.feeDefault.model.action;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.info.FeedefSetterCategServ;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFeedefEnforceCategServ extends ActionVisitorTemplateEnforce<FeedefInfo> {
	
	@Override protected FeedefInfo enforceHook(FeedefInfo recordInfo) {
		InfoSetter<FeedefInfo> setter = new FeedefSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
