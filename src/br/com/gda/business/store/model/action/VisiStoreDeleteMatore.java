package br.com.gda.business.store.model.action;

import java.sql.Connection;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.RootMatoreDeleteByStore;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteMatore extends ActionVisitorTemplateAction<StoreInfo, MatoreInfo> {
	public VisiStoreDeleteMatore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> getActionHook(DeciTreeOption<MatoreInfo> option) {
		return new RootMatoreDeleteByStore(option).toAction();
	}
}
