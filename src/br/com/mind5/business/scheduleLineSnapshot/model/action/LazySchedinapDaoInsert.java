package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedinapDaoInsert extends ActionLazyTemplateV2<SchedinapInfo, SchedinapInfo> {
	
	public LazySchedinapDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedinapInfo> translateRecordInfosHook(List<SchedinapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedinapInfo> getInstanceOfActionHook(DeciTreeOption<SchedinapInfo> option) {
		return new StdSchedinapDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<SchedinapInfo> translateResultHook(DeciResult<SchedinapInfo> result) {
		return result;
	}
}
