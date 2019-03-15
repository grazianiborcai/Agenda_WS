package br.com.gda.business.store.model.action;

import java.sql.Connection;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolevateDeleteAll;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStolevate extends ActionVisitorTemplateAction<StoreInfo, StolevateInfo> {
	public VisiStoreDeleteStolevate(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StolevateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolevateInfo> getActionHook(DeciTreeOption<StolevateInfo> option) {
		return new RootStolevateDeleteAll(option).toAction();
	}
}
