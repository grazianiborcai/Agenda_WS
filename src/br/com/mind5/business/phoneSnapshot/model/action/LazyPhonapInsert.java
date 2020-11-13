package br.com.mind5.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPhonapInsert extends ActionLazyTemplate<PhonapInfo, PhonapInfo> {

	public LazyPhonapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhonapInfo> translateRecordInfosHook(List<PhonapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<PhonapInfo> getInstanceOfActionHook(DeciTreeOption<PhonapInfo> option) {
		return new StdPhonapDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<PhonapInfo> translateResultHook(DeciResult<PhonapInfo> result) {
		return result;
	}
}
