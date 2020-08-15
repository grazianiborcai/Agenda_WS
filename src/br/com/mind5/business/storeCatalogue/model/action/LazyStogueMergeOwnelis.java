package br.com.mind5.business.storeCatalogue.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStogueMergeOwnelis extends ActionLazyTemplateV2<StogueInfo, StogueInfo> {

	public LazyStogueMergeOwnelis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StogueInfo> translateRecordInfosHook(List<StogueInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StogueInfo> getInstanceOfActionHook(DeciTreeOption<StogueInfo> option) {
		return new StdStogueMergeOwnelis(option);
	}
	
	
	
	@Override protected DeciResult<StogueInfo> translateResultHook(DeciResult<StogueInfo> result) {
		return result;
	}
}
