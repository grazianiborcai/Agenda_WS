package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStolateMergeToDeleteKey extends ActionLazyTemplate<StolateInfo, StolateInfo> {
	
	public LazyStolateMergeToDeleteKey(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolateInfo> translateRecordInfosHook(List<StolateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StolateInfo> getInstanceOfActionHook(DeciTreeOption<StolateInfo> option) {
		return new StdStolateMergeToDeleteKey(option);
	}
	
	
	
	@Override protected DeciResult<StolateInfo> translateResultHook(DeciResult<StolateInfo> result) {
		return result;
	}
}
