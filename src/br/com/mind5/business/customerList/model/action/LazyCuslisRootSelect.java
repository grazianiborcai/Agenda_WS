package br.com.mind5.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCuslisRootSelect extends ActionLazyTemplateV1<CuslisInfo, CuslisInfo> {
	
	public LazyCuslisRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CuslisInfo> translateRecordInfosHook(List<CuslisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CuslisInfo> getInstanceOfActionHook(DeciTreeOption<CuslisInfo> option) {
		return new RootCuslisSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CuslisInfo> translateResultHook(DeciResult<CuslisInfo> result) {
		return result;
	}
}
