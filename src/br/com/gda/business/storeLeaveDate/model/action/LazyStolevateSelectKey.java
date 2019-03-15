package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStolevateSelectKey extends ActionLazyTemplate<StolevateInfo, StolevateInfo> {
	
	public LazyStolevateSelectKey(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolevateInfo> translateRecordInfosHook(List<StolevateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<StolevateInfo> getInstanceOfActionHook(DeciTreeOption<StolevateInfo> option) {
		return new StdStolevateSelectKey(option);
	}
	
	
	
	@Override protected DeciResult<StolevateInfo> translateResultHook(DeciResult<StolevateInfo> result) {
		return result;
	}
}
