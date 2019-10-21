package br.com.mind5.business.store.model.action;

import java.sql.Connection;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.RootStolateDelete;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStolate extends ActionVisitorTemplateAction<StoreInfo, StolateInfo> {
	public VisiStoreDeleteStolate(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> getActionHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateDelete(option).toAction();
	}
}
