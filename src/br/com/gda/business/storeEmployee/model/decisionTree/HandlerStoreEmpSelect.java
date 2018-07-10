package br.com.gda.business.storeEmployee.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerStoreEmpSelect extends DeciActionHandlerTemplate<StoreEmpInfo, StoreEmpInfo> {
	
	public HandlerStoreEmpSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreEmpInfo> translateRecordInfosHook(List<StoreEmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  DeciAction<StoreEmpInfo> getInstanceOfActionHook(DeciTreeOption<StoreEmpInfo> option) {
		return new ActionStoreEmpSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoreEmpInfo> translateResultHook(DeciResult<StoreEmpInfo> result) {
		return result;
	}
}
