package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneUpsertdel;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreUpsertPhone extends ActionVisitorTemplateAction<StoreInfo, PhoneInfo> {
	public VisiStoreUpsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (StoreInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneUpsertdel(option).toAction();
	}
}
