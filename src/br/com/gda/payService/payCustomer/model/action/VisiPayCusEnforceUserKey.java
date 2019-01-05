package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

final class VisiPayCusEnforceUserKey extends ActionVisitorTemplateEnforce<PayCusInfo> {
	//TODO: Mover para Setter?
	@Override protected PayCusInfo enforceHook(PayCusInfo recordInfo) {
		PayCusInfo enforcedRecord = new PayCusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		return enforcedRecord;
	}
}
