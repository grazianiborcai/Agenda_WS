package br.com.mind5.masterData.stateSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStatarchMergeCountry extends ActionLazyTemplate<StatarchInfo, StatarchInfo> {
	
	public LazyStatarchMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StatarchInfo> translateRecordInfosHook(List<StatarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StatarchInfo> getInstanceOfActionHook(DeciTreeOption<StatarchInfo> option) {
		return new StdStatarchMergeCountry(option);
	}
	
	
	
	@Override protected DeciResult<StatarchInfo> translateResultHook(DeciResult<StatarchInfo> result) {		
		return result;
	}
}
