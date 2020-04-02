package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneInsert;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreInsertPhone extends ActionVisitorTemplateAction<StoreInfo, PhoneInfo> {
	public VisiStoreInsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return PhoneCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneInsert(option).toAction();
	}
}
