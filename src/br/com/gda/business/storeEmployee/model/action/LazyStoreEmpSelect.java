package br.com.gda.business.storeEmployee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStoreEmpSelect extends ActionLazyTemplate<StoreEmpInfo, StoreEmpInfo> {
	
	public LazyStoreEmpSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreEmpInfo> translateRecordInfosHook(List<StoreEmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<StoreEmpInfo> getInstanceOfActionHook(DeciTreeOption<StoreEmpInfo> option) {
		return new StdStoreEmpSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoreEmpInfo> translateResultHook(DeciResult<StoreEmpInfo> result) {
		return result;
	}
}
