package br.com.gda.business.ownerStore_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.business.store.info.StoreCopier;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwntoreDeleteStore extends ActionVisitorTemplateAction<OwntoreInfo, StoreInfo> {
	public VisiOwntoreDeleteStore(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class, StoreInfo.class);
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<OwntoreInfo> recordInfos) {
		return StoreCopier.copyFromOwntore(recordInfos);
	}
	
	
	
	@Override protected ActionStd<StoreInfo> getActionHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreDelete(option).toAction();
	}
}
