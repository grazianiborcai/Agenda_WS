package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneDelete;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeletePhone extends ActionVisitorTemplateAction<OwnerInfo, PhoneInfo> {
	public VisiOwnerDeletePhone(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneDelete(option).toAction();
	}
}
