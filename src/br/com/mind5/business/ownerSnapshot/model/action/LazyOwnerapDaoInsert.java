package br.com.mind5.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOwnerapDaoInsert extends ActionLazyTemplate<OwnerapInfo, OwnerapInfo> {
	
	public LazyOwnerapDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnerapInfo> translateRecordInfosHook(List<OwnerapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<OwnerapInfo> getInstanceOfActionHook(DeciTreeOption<OwnerapInfo> option) {
		return new StdOwnerapDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<OwnerapInfo> translateResultHook(DeciResult<OwnerapInfo> result) {
		return result;
	}
}
