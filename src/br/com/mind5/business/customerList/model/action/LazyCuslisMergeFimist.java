package br.com.mind5.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCuslisMergeFimist extends ActionLazyTemplate<CuslisInfo, CuslisInfo> {
	
	public LazyCuslisMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CuslisInfo> translateRecordInfosHook(List<CuslisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CuslisInfo> getInstanceOfActionHook(DeciTreeOption<CuslisInfo> option) {
		return new StdCuslisMergeFimist(option);
	}
	
	
	
	@Override protected DeciResult<CuslisInfo> translateResultHook(DeciResult<CuslisInfo> result) {
		return result;
	}
}
