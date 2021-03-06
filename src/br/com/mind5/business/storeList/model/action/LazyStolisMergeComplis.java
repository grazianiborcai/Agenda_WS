package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStolisMergeComplis extends ActionLazyTemplate<StolisInfo, StolisInfo> {
	
	public LazyStolisMergeComplis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolisInfo> translateRecordInfosHook(List<StolisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StolisInfo> getInstanceOfActionHook(DeciTreeOption<StolisInfo> option) {
		return new StdStolisMergeComplis(option);
	}
	
	
	
	@Override protected DeciResult<StolisInfo> translateResultHook(DeciResult<StolisInfo> result) {
		return result;
	}
}
