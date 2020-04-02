package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmposSelect extends ActionLazyTemplate<EmposInfo, EmposInfo> {
	
	public LazyEmposSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmposInfo> translateRecordInfosHook(List<EmposInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmposInfo> getInstanceOfActionHook(DeciTreeOption<EmposInfo> option) {
		return new StdEmposSelect(option);
	}
	
	
	
	@Override protected DeciResult<EmposInfo> translateResultHook(DeciResult<EmposInfo> result) {
		return result;
	}
}
