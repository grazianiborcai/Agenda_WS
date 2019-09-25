package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreCopier;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreRootDelete;
import br.com.gda.business.store.model.decisionTree.RootStoreSearch;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteStore extends ActionVisitorTemplateAction<OwnerInfo, StoreInfo> {
	public VisiOwnerDeleteStore(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, StoreInfo.class);
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return StoreCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected ActionStd<StoreInfo> getActionHook(DeciTreeOption<StoreInfo> option) {
		
		ActionStd<StoreInfo> storeSearch = new RootStoreSearch(option).toAction();
		ActionLazy<StoreInfo> storeDelete = new LazyStoreRootDelete(option.conn, option.schemaName);
		
		storeSearch.addPostAction(storeDelete);
		
		return storeSearch;
	}
}
