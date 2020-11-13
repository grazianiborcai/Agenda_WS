package br.com.mind5.business.ownerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.RootOwnelisSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOwnelisRootSelect extends ActionLazyTemplate<OwnelisInfo, OwnelisInfo> {
	
	public LazyOwnelisRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnelisInfo> translateRecordInfosHook(List<OwnelisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<OwnelisInfo> getInstanceOfActionHook(DeciTreeOption<OwnelisInfo> option) {
		return new RootOwnelisSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OwnelisInfo> translateResultHook(DeciResult<OwnelisInfo> result) {
		return result;
	}
}
