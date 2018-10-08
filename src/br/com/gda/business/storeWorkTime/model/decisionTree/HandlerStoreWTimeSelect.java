package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerStoreWTimeSelect extends ActionLazyTemplate<StoreWTimeInfo, StoreWTimeInfo> {
	
	public HandlerStoreWTimeSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreWTimeInfo> translateRecordInfosHook(List<StoreWTimeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<StoreWTimeInfo> getInstanceOfActionHook(DeciTreeOption<StoreWTimeInfo> option) {
		return new ActionStoreWTimeSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoreWTimeInfo> translateResultHook(DeciResult<StoreWTimeInfo> result) {
		return result;
	}
}
