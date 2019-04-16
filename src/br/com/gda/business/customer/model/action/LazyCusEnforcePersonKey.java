package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCusEnforcePersonKey extends ActionLazyTemplate<CusInfo, CusInfo> {
	
	public LazyCusEnforcePersonKey(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusInfo> translateRecordInfosHook(List<CusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusInfo> getInstanceOfActionHook(DeciTreeOption<CusInfo> option) {
		return new StdCusEnforcePersonKey(option);
	}
	
	
	
	@Override protected DeciResult<CusInfo> translateResultHook(DeciResult<CusInfo> result) {
		return result;
	}
}
