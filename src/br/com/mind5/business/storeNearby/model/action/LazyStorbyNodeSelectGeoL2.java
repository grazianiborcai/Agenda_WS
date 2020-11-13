package br.com.mind5.business.storeNearby.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.NodeStorbySelectGeoL2;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorbyNodeSelectGeoL2 extends ActionLazyTemplate<StorbyInfo, StorbyInfo> {

	public LazyStorbyNodeSelectGeoL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorbyInfo> translateRecordInfosHook(List<StorbyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StorbyInfo> getInstanceOfActionHook(DeciTreeOption<StorbyInfo> option) {
		return new NodeStorbySelectGeoL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorbyInfo> translateResultHook(DeciResult<StorbyInfo> result) {
		return result;
	}
}
