package br.com.mind5.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStolateEnforceYear extends ActionLazyTemplateV2<StolateInfo, StolateInfo> {
	
	public LazyStolateEnforceYear(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StolateInfo> translateRecordInfosHook(List<StolateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StolateInfo> getInstanceOfActionHook(DeciTreeOption<StolateInfo> option) {
		return new StdStolateEnforceYear(option);
	}
	
	
	
	@Override protected DeciResult<StolateInfo> translateResultHook(DeciResult<StolateInfo> result) {
		return result;
	}
}
