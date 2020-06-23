package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedinapMergeMatsnap extends ActionLazyTemplateV2<SchedinapInfo, SchedinapInfo> {
	
	public LazySchedinapMergeMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedinapInfo> translateRecordInfosHook(List<SchedinapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedinapInfo> getInstanceOfActionHook(DeciTreeOption<SchedinapInfo> option) {
		return new StdSchedinapMergeMatsnap(option);
	}
	
	
	
	@Override protected DeciResult<SchedinapInfo> translateResultHook(DeciResult<SchedinapInfo> result) {		
		return result;
	}
}
