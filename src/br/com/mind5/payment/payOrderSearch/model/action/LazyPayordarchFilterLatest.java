package br.com.mind5.payment.payOrderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class LazyPayordarchFilterLatest extends ActionLazyTemplate<PayordarchInfo, PayordarchInfo> {
	
	public LazyPayordarchFilterLatest(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordarchInfo> translateRecordInfosHook(List<PayordarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordarchInfo> getInstanceOfActionHook(DeciTreeOption<PayordarchInfo> option) {
		return new StdPayordarchFilterLatest(option);
	}
	
	
	
	@Override protected DeciResult<PayordarchInfo> translateResultHook(DeciResult<PayordarchInfo> result) {
		return result;
	}
}
