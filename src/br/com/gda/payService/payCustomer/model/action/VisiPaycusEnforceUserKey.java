package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class VisiPaycusEnforceUserKey extends ActionVisitorTemplateEnforce<PaycusInfo> {
	//TODO: Mover para Setter?
	@Override protected PaycusInfo enforceHook(PaycusInfo recordInfo) {
		PaycusInfo enforcedRecord = new PaycusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		return enforcedRecord;
	}
}
