package br.com.mind5.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.decisionTree.RootSchedyearSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedyearRootSelect extends ActionLazyTemplate<SchedyearInfo, SchedyearInfo> {
	
	public LazySchedyearRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedyearInfo> translateRecordInfosHook(List<SchedyearInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedyearInfo> getInstanceOfActionHook(DeciTreeOption<SchedyearInfo> option) {
		return new RootSchedyearSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SchedyearInfo> translateResultHook(DeciResult<SchedyearInfo> result) {
		return result;
	}
}
