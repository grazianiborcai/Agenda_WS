package br.com.mind5.business.storeProspect.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStoprosEnforceLChanged extends ActionLazyTemplate<StoprosInfo, StoprosInfo> {
	
	public LazyStoprosEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoprosInfo> translateRecordInfosHook(List<StoprosInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoprosInfo> getInstanceOfActionHook(DeciTreeOption<StoprosInfo> option) {
		return new StdStoprosEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<StoprosInfo> translateResultHook(DeciResult<StoprosInfo> result) {
		return result;
	}
}
