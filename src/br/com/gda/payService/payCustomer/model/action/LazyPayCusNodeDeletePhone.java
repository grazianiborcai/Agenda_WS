package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.model.decisionTree.NodePayCusDeletePhone;

public final class LazyPayCusNodeDeletePhone extends ActionLazyTemplate<PayCusInfo, PayCusInfo> {
	
	public LazyPayCusNodeDeletePhone(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayCusInfo> translateRecordInfosHook(List<PayCusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayCusInfo> getInstanceOfActionHook(DeciTreeOption<PayCusInfo> option) {
		return new NodePayCusDeletePhone(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayCusInfo> translateResultHook(DeciResult<PayCusInfo> result) {
		return result;
	}
}
