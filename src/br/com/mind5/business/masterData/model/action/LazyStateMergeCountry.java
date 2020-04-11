package br.com.mind5.business.masterData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStateMergeCountry extends ActionLazyTemplateV1<StateInfo, StateInfo> {
	
	public LazyStateMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StateInfo> translateRecordInfosHook(List<StateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StateInfo> getInstanceOfActionHook(DeciTreeOption<StateInfo> option) {
		return new StdStateMergeCountry(option);
	}
	
	
	
	@Override protected DeciResult<StateInfo> translateResultHook(DeciResult<StateInfo> result) {		
		return result;
	}
}
