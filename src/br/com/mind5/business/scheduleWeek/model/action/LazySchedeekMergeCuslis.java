package br.com.mind5.business.scheduleWeek.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedeekMergeCuslis extends ActionLazyTemplate<SchedeekInfo, SchedeekInfo> {
	
	public LazySchedeekMergeCuslis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedeekInfo> translateRecordInfosHook(List<SchedeekInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedeekInfo> getInstanceOfActionHook(DeciTreeOption<SchedeekInfo> option) {
		return new StdSchedeekMergeCuslis(option);
	}
	
	
	
	@Override protected DeciResult<SchedeekInfo> translateResultHook(DeciResult<SchedeekInfo> result) {
		return result;
	}
}
