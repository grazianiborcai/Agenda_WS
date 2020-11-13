package br.com.mind5.masterData.state.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStateMergeCountry extends ActionLazyTemplate<StateInfo, StateInfo> {
	
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
