package br.com.mind5.business.scheduleDayData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedaytaMergeToSelect extends ActionLazyTemplate<SchedaytaInfo, SchedaytaInfo> {
	
	public LazySchedaytaMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedaytaInfo> translateRecordInfosHook(List<SchedaytaInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedaytaInfo> getInstanceOfActionHook(DeciTreeOption<SchedaytaInfo> option) {
		return new StdSchedaytaMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<SchedaytaInfo> translateResultHook(DeciResult<SchedaytaInfo> result) {
		return result;
	}
}
