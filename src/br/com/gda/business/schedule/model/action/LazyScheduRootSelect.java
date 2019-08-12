package br.com.gda.business.schedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.model.decisionTree.RootOrderemSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyScheduRootSelect extends ActionLazyTemplate<ScheduInfo, ScheduInfo> {
	
	public LazyScheduRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<ScheduInfo> translateRecordInfosHook(List<ScheduInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<ScheduInfo> getInstanceOfActionHook(DeciTreeOption<ScheduInfo> option) {
		return new RootOrderemSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<ScheduInfo> translateResultHook(DeciResult<ScheduInfo> result) {
		return result;
	}
}
