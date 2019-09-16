package br.com.gda.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOwnerapInsert extends ActionLazyTemplate<OwnerapInfo, OwnerapInfo> {
	
	public LazyOwnerapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnerapInfo> translateRecordInfosHook(List<OwnerapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OwnerapInfo> getInstanceOfActionHook(DeciTreeOption<OwnerapInfo> option) {
		return new StdOwnerapInsert(option);
	}
	
	
	
	@Override protected DeciResult<OwnerapInfo> translateResultHook(DeciResult<OwnerapInfo> result) {
		return result;
	}
}
