package br.com.gda.business.feeStore.model.action;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.masterData.info.common.FeeCateg;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFeetoreEnforceCategServ extends ActionVisitorTemplateEnforce<FeetoreInfo> {
	
	@Override protected FeetoreInfo enforceHook(FeetoreInfo recordInfo) {
		recordInfo.codFeeCateg = FeeCateg.SERVICE.getCodCateg();
		return recordInfo;
	}
}
