package br.com.mind5.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCuslisMergePersolis extends ActionLazyTemplate<CuslisInfo, CuslisInfo> {
	
	public LazyCuslisMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CuslisInfo> translateRecordInfosHook(List<CuslisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CuslisInfo> getInstanceOfActionHook(DeciTreeOption<CuslisInfo> option) {
		return new StdCuslisMergePersolis(option);
	}
	
	
	
	@Override protected DeciResult<CuslisInfo> translateResultHook(DeciResult<CuslisInfo> result) {
		return result;
	}
}
