package br.com.mind5.payment.payOrderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.decisionTree.RootPayordarchSelect;

public final class LazyPayordarchRootSelect extends ActionLazyTemplate<PayordarchInfo, PayordarchInfo> {
	
	public LazyPayordarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordarchInfo> translateRecordInfosHook(List<PayordarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<PayordarchInfo> getInstanceOfActionHook(DeciTreeOption<PayordarchInfo> option) {
		return new RootPayordarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayordarchInfo> translateResultHook(DeciResult<PayordarchInfo> result) {
		return result;
	}
}
