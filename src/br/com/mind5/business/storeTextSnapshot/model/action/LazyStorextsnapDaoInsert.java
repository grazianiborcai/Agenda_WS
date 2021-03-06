package br.com.mind5.business.storeTextSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorextsnapDaoInsert extends ActionLazyTemplate<StorextsnapInfo, StorextsnapInfo> {
	
	public LazyStorextsnapDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorextsnapInfo> translateRecordInfosHook(List<StorextsnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StorextsnapInfo> getInstanceOfActionHook(DeciTreeOption<StorextsnapInfo> option) {
		return new StdStorextsnapDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<StorextsnapInfo> translateResultHook(DeciResult<StorextsnapInfo> result) {
		return result;
	}
}
