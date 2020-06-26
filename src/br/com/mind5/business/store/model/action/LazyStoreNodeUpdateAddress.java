package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.NodeStoreUpdateAddress;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStoreNodeUpdateAddress extends ActionLazyTemplateV2<StoreInfo, StoreInfo> {

	public LazyStoreNodeUpdateAddress(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreInfo> translateRecordInfosHook(List<StoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoreInfo> getInstanceOfActionHook(DeciTreeOption<StoreInfo> option) {
		return new NodeStoreUpdateAddress(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoreInfo> translateResultHook(DeciResult<StoreInfo> result) {
		return result;
	}
}
