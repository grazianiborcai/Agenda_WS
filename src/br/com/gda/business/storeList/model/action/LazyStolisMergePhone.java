package br.com.gda.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStolisMergePhone extends ActionLazyTemplate<StolisInfo, StolisInfo> {
	
	public LazyStolisMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolisInfo> translateRecordInfosHook(List<StolisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StolisInfo> getInstanceOfActionHook(DeciTreeOption<StolisInfo> option) {
		return new StdStolisMergePhone(option);
	}
	
	
	
	@Override protected DeciResult<StolisInfo> translateResultHook(DeciResult<StolisInfo> result) {
		return result;
	}
}
