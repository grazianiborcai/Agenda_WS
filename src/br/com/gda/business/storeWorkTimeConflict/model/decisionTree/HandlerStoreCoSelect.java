package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerStoreCoSelect extends DeciActionHandlerTemplate<StoreCoInfo, StoreCoInfo> {
	
	public HandlerStoreCoSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreCoInfo> translateRecordInfosHook(List<StoreCoInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  DeciAction<StoreCoInfo> getInstanceOfActionHook(DeciTreeOption<StoreCoInfo> option) {
		return new ActionStoreCoSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoreCoInfo> translateResultHook(DeciResult<StoreCoInfo> result) {
		return result;
	}
}
