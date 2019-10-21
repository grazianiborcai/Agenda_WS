package br.com.mind5.business.store.model.action;

import java.sql.Connection;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.RootStowotmDeleteAll;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStowotm extends ActionVisitorTemplateAction<StoreInfo, StowotmInfo> {
	public VisiStoreDeleteStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> getActionHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmDeleteAll(option).toAction();
	}
}
