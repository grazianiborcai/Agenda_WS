package br.com.mind5.business.store.model.action;

import java.sql.Connection;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreDeleteByStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteMatore extends ActionVisitorTemplateAction<StoreInfo, MatoreInfo> {
	public VisiStoreDeleteMatore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> getActionHook(DeciTreeOption<MatoreInfo> option) {
		return new RootMatoreDeleteByStore(option).toAction();
	}
}
