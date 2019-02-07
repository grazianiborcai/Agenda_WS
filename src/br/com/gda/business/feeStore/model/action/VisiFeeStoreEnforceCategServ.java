package br.com.gda.business.feeStore.model.action;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.masterData.info.common.FeeCateg;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFeeStoreEnforceCategServ extends ActionVisitorTemplateEnforce<FeeStoreInfo> {
	
	@Override protected FeeStoreInfo enforceHook(FeeStoreInfo recordInfo) {
		recordInfo.codFeeCateg = FeeCateg.SERVICE.getCodCateg();
		return recordInfo;
	}
}
