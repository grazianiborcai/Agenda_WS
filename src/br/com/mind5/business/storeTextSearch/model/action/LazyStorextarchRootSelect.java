package br.com.mind5.business.storeTextSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.decisionTree.RootStorextarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorextarchRootSelect extends ActionLazyTemplate<StorextarchInfo, StorextarchInfo> {

	public LazyStorextarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorextarchInfo> translateRecordInfosHook(List<StorextarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StorextarchInfo> getInstanceOfActionHook(DeciTreeOption<StorextarchInfo> option) {
		return new RootStorextarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorextarchInfo> translateResultHook(DeciResult<StorextarchInfo> result) {
		return result;
	}
}
