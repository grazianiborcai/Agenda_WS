package br.com.mind5.business.scheduleWeek.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.decisionTree.RootSchedeekSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedeekRootSelect extends ActionLazyTemplate<SchedeekInfo, SchedeekInfo> {
	
	public LazySchedeekRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedeekInfo> translateRecordInfosHook(List<SchedeekInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedeekInfo> getInstanceOfActionHook(DeciTreeOption<SchedeekInfo> option) {
		return new RootSchedeekSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SchedeekInfo> translateResultHook(DeciResult<SchedeekInfo> result) {
		return result;
	}
}
