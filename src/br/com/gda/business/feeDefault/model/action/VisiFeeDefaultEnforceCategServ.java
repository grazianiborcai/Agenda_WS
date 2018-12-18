package br.com.gda.business.feeDefault.model.action;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.masterData.info.FeeCateg;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFeeDefaultEnforceCategServ extends ActionVisitorTemplateEnforce<FeeDefaultInfo> {
	
	@Override protected FeeDefaultInfo enforceHook(FeeDefaultInfo recordInfo) {
		recordInfo.codFeeCateg = FeeCateg.SERVICE.getCodCateg();
		return recordInfo;
	}
}
