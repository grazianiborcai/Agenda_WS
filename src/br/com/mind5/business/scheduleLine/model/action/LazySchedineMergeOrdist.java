package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedineMergeOrdist extends ActionLazyTemplate<SchedineInfo, SchedineInfo> {
	
	public LazySchedineMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedineInfo> translateRecordInfosHook(List<SchedineInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedineInfo> getInstanceOfActionHook(DeciTreeOption<SchedineInfo> option) {
		return new StdSchedineMergeOrdist(option);
	}
	
	
	
	@Override protected DeciResult<SchedineInfo> translateResultHook(DeciResult<SchedineInfo> result) {		
		return result;
	}
}
