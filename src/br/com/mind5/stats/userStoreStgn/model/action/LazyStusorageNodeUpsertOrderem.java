package br.com.mind5.stats.userStoreStgn.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.userStoreStgn.model.decisionTree.NodeStusorageUpsertOrderem;

public final class LazyStusorageNodeUpsertOrderem extends ActionLazyTemplate<StusorageInfo, StusorageInfo> {

	public LazyStusorageNodeUpsertOrderem(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorageInfo> translateRecordInfosHook(List<StusorageInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorageInfo> getInstanceOfActionHook(DeciTreeOption<StusorageInfo> option) {
		return new NodeStusorageUpsertOrderem(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StusorageInfo> translateResultHook(DeciResult<StusorageInfo> result) {
		return result;
	}
}
