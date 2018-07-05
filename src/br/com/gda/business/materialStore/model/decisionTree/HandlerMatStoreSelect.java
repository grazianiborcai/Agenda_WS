package br.com.gda.business.materialStore.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerMatStoreSelect extends DeciActionHandlerTemplate<MatStoreInfo, MatStoreInfo> {
	
	public HandlerMatStoreSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatStoreInfo> translateRecordInfosHook(List<MatStoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  DeciAction<MatStoreInfo> getInstanceOfActionHook(DeciTreeOption<MatStoreInfo> option) {
		return new ActionMatStoreSelect(option);
	}
	
	
	
	@Override protected DeciResult<MatStoreInfo> translateResultHook(DeciResult<MatStoreInfo> result) {
		return result;
	}
}
