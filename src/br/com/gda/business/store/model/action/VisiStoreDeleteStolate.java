package br.com.gda.business.store.model.action;

import java.sql.Connection;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolateDeleteAll;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStolate extends ActionVisitorTemplateAction<StoreInfo, StolateInfo> {
	public VisiStoreDeleteStolate(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> getActionHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateDeleteAll(option).toAction();
	}
}
