package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmposMergeToDelete extends ActionLazyTemplate<EmposInfo, EmposInfo> {
	
	public LazyEmposMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmposInfo> translateRecordInfosHook(List<EmposInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmposInfo> getInstanceOfActionHook(DeciTreeOption<EmposInfo> option) {
		return new StdEmposMergeToDelete(option);
	}
	
	
	
	@Override protected DeciResult<EmposInfo> translateResultHook(DeciResult<EmposInfo> result) {
		return result;
	}
}
