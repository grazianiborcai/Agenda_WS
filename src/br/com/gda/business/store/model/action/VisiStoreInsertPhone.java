package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phone.info.PhoneCopier;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneInsert;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreInsertPhone extends ActionVisitorTemplateAction<StoreInfo, PhoneInfo> {
	public VisiStoreInsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return PhoneCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneInsert(option).toAction();
	}
}
