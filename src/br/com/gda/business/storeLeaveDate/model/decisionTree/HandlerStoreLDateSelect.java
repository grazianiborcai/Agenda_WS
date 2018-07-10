package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerStoreLDateSelect extends DeciActionHandlerTemplate<StoreLDateInfo, StoreLDateInfo> {
	
	public HandlerStoreLDateSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreLDateInfo> translateRecordInfosHook(List<StoreLDateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  DeciAction<StoreLDateInfo> getInstanceOfActionHook(DeciTreeOption<StoreLDateInfo> option) {
		return new ActionStoreLDateSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoreLDateInfo> translateResultHook(DeciResult<StoreLDateInfo> result) {
		return result;
	}
}
