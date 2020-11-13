package br.com.mind5.business.personList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPersolisEnforceRestricted extends ActionLazyTemplate<PersolisInfo, PersolisInfo> {

	public LazyPersolisEnforceRestricted(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersolisInfo> translateRecordInfosHook(List<PersolisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PersolisInfo> getInstanceOfActionHook(DeciTreeOption<PersolisInfo> option) {
		return new StdPersolisEnforceRestricted(option);
	}
	
	
	
	@Override protected DeciResult<PersolisInfo> translateResultHook(DeciResult<PersolisInfo> result) {
		return result;
	}
}
