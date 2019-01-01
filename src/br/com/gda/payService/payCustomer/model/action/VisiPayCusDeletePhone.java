package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

final class VisiPayCusDeletePhone extends ActionVisitorTemplateAction<PayCusInfo, PhoneInfo> {
	public VisiPayCusDeletePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PayCusInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PayCusInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PayCusInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneDelete(option).toAction();
	}
}
