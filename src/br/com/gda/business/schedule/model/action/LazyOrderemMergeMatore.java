package br.com.gda.business.schedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrderemMergeMatore extends ActionLazyTemplate<ScheduInfo, ScheduInfo> {
	
	public LazyOrderemMergeMatore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<ScheduInfo> translateRecordInfosHook(List<ScheduInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<ScheduInfo> getInstanceOfActionHook(DeciTreeOption<ScheduInfo> option) {
		return new StdOrderemMergeMatore(option);
	}
	
	
	
	@Override protected DeciResult<ScheduInfo> translateResultHook(DeciResult<ScheduInfo> result) {		
		return result;
	}
}
