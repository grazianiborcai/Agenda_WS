package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneUpsertdel;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusUpsertPhone extends ActionVisitorTemplateAction<CusInfo, PhoneInfo> {
	public VisiCusUpsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CusInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (CusInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneUpsertdel(option).toAction();
	}
}
