package br.com.gda.payment.payOrderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;
import br.com.gda.payment.payOrderSearch.model.decisionTree.RootPayordarchSelect;

public final class LazyPayordarchRootSelect extends ActionLazyTemplate<PayordarchInfo, PayordarchInfo> {
	
	public LazyPayordarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordarchInfo> translateRecordInfosHook(List<PayordarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordarchInfo> getInstanceOfActionHook(DeciTreeOption<PayordarchInfo> option) {
		return new RootPayordarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayordarchInfo> translateResultHook(DeciResult<PayordarchInfo> result) {
		return result;
	}
}
