package br.com.mind5.business.storeCatalogue.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStogueMergeMatoup extends ActionLazyTemplate<StogueInfo, StogueInfo> {

	public LazyStogueMergeMatoup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StogueInfo> translateRecordInfosHook(List<StogueInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StogueInfo> getInstanceOfActionHook(DeciTreeOption<StogueInfo> option) {
		return new StdStogueMergeMatoup(option);
	}
	
	
	
	@Override protected DeciResult<StogueInfo> translateResultHook(DeciResult<StogueInfo> result) {
		return result;
	}
}
