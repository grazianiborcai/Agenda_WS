package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStolisMergeAddress extends ActionLazyTemplate<StolisInfo, StolisInfo> {
	
	public LazyStolisMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolisInfo> translateRecordInfosHook(List<StolisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StolisInfo> getInstanceOfActionHook(DeciTreeOption<StolisInfo> option) {
		return new StdStolisMergeAddress(option);
	}
	
	
	
	@Override protected DeciResult<StolisInfo> translateResultHook(DeciResult<StolisInfo> result) {
		return result;
	}
}
