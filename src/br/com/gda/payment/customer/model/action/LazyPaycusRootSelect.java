package br.com.gda.payment.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.model.decisionTree.RootPaycusSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPaycusRootSelect extends ActionLazyTemplate<PaycusInfo, PaycusInfo> {

	public LazyPaycusRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaycusInfo> translateRecordInfosHook(List<PaycusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaycusInfo> getInstanceOfActionHook(DeciTreeOption<PaycusInfo> option) {
		return new RootPaycusSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PaycusInfo> translateResultHook(DeciResult<PaycusInfo> result) {
		return result;
	}
}
