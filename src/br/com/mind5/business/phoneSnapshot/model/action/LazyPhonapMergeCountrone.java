package br.com.mind5.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPhonapMergeCountrone extends ActionLazyTemplate<PhonapInfo, PhonapInfo> {
	
	public LazyPhonapMergeCountrone(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhonapInfo> translateRecordInfosHook(List<PhonapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PhonapInfo> getInstanceOfActionHook(DeciTreeOption<PhonapInfo> option) {
		return new StdPhonapMergeCountrone(option);
	}
	
	
	
	@Override protected DeciResult<PhonapInfo> translateResultHook(DeciResult<PhonapInfo> result) {
		return result;
	}
}
