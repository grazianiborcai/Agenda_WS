package br.com.gda.business.feeStore.model.action;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.info.FeetoreSetterCategServ;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFeetoreEnforceCategServ extends ActionVisitorTemplateEnforce<FeetoreInfo> {
	
	@Override protected FeetoreInfo enforceHook(FeetoreInfo recordInfo) {
		InfoSetter<FeetoreInfo> setter = new FeetoreSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
