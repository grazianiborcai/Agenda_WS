package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolateDelete;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStolateRootDelete extends ActionLazyTemplate<StolateInfo, StolateInfo> {
	
	public LazyStolateRootDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolateInfo> translateRecordInfosHook(List<StolateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StolateInfo> getInstanceOfActionHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateDelete(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StolateInfo> translateResultHook(DeciResult<StolateInfo> result) {
		return result;
	}
}
