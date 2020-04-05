package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.store.info.StoreCopier;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteCascade;
import br.com.mind5.business.store.model.decisionTree.RootStoreSearch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteStore extends ActionVisitorTemplateActionV1<OwnerInfo, StoreInfo> {
	public VisiOwnerDeleteStore(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, StoreInfo.class);
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return StoreCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<StoreInfo> getActionHook(DeciTreeOption<StoreInfo> option) {
		
		ActionStdV1<StoreInfo> storeSearch = new RootStoreSearch(option).toAction();
		ActionLazyV1<StoreInfo> storeDelete = new LazyStoreNodeDeleteCascade(option.conn, option.schemaName);
		
		storeSearch.addPostAction(storeDelete);
		
		return storeSearch;
	}
}
