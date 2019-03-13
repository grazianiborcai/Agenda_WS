package br.com.gda.business.store.model.action;

import java.sql.Connection;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmDeleteAll;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStowotm extends ActionVisitorTemplateAction<StoreInfo, StowotmInfo> {
	public VisiStoreDeleteStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> getActionHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmDeleteAll(option).toAction();
	}
}
