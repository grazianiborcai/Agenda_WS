package br.com.mind5.payment.storePartnerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class LazyStoparchSelect extends ActionLazyTemplate<StoparchInfo, StoparchInfo> {
	
	public LazyStoparchSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparchInfo> translateRecordInfosHook(List<StoparchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoparchInfo> getInstanceOfActionHook(DeciTreeOption<StoparchInfo> option) {
		return new StdStoparchSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoparchInfo> translateResultHook(DeciResult<StoparchInfo> result) {
		return result;
	}
}
