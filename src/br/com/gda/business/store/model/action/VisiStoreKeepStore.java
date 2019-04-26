package br.com.gda.business.store.model.action;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreKeeper;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateKeep;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreKeepStore extends ActionVisitorTemplateKeep<StoreInfo, StoreInfo> {

	public VisiStoreKeepStore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoreInfo> getActionHook(DeciTreeOption<StoreInfo> option) {
		ActionStd<StoreInfo> actionSelect = new StdStoreEnforceKey(option);
		actionSelect.addPostAction(new LazyStoreRootSelect(option.conn, option.schemaName));
		return actionSelect;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StoreInfo>> getKeeperClassHook() {
		return StoreKeeper.class;
	}
}
