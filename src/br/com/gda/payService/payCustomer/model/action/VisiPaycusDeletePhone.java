package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class VisiPaycusDeletePhone extends ActionVisitorTemplateAction<PaycusInfo, PhoneInfo> {
	public VisiPaycusDeletePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PaycusInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PaycusInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PaycusInfo eachRecord : recordInfos) {
			results.add(eachRecord.phone);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneDelete(option).toAction();
	}
}
