package br.com.gda.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedinapMergeMatsnap extends ActionLazyTemplate<SchedinapInfo, SchedinapInfo> {
	
	public LazySchedinapMergeMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedinapInfo> translateRecordInfosHook(List<SchedinapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedinapInfo> getInstanceOfActionHook(DeciTreeOption<SchedinapInfo> option) {
		return new StdSchedinapMergeMatsnap(option);
	}
	
	
	
	@Override protected DeciResult<SchedinapInfo> translateResultHook(DeciResult<SchedinapInfo> result) {		
		return result;
	}
}
