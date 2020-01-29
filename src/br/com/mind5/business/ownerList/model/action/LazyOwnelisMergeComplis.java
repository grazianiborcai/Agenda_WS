package br.com.mind5.business.ownerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOwnelisMergeComplis extends ActionLazyTemplate<OwnelisInfo, OwnelisInfo> {
	
	public LazyOwnelisMergeComplis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnelisInfo> translateRecordInfosHook(List<OwnelisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OwnelisInfo> getInstanceOfActionHook(DeciTreeOption<OwnelisInfo> option) {
		return new StdOwnelisMergeComplis(option);
	}
	
	
	
	@Override protected DeciResult<OwnelisInfo> translateResultHook(DeciResult<OwnelisInfo> result) {
		return result;
	}
}
