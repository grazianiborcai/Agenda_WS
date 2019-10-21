package br.com.mind5.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOwnerapMergeComplis extends ActionLazyTemplate<OwnerapInfo, OwnerapInfo> {
	
	public LazyOwnerapMergeComplis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnerapInfo> translateRecordInfosHook(List<OwnerapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OwnerapInfo> getInstanceOfActionHook(DeciTreeOption<OwnerapInfo> option) {
		return new StdOwnerapMergeComplis(option);
	}
	
	
	
	@Override protected DeciResult<OwnerapInfo> translateResultHook(DeciResult<OwnerapInfo> result) {
		return result;
	}
}
