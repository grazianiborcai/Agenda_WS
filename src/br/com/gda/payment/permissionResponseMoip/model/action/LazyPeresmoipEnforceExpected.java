package br.com.gda.payment.permissionResponseMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;

public final class LazyPeresmoipEnforceExpected extends ActionLazyTemplate<PeresmoipInfo, PeresmoipInfo> {
	
	public LazyPeresmoipEnforceExpected(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PeresmoipInfo> translateRecordInfosHook(List<PeresmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PeresmoipInfo> getInstanceOfActionHook(DeciTreeOption<PeresmoipInfo> option) {
		return new StdPeresmoipEnforceExpected(option);
	}
	
	
	
	@Override protected DeciResult<PeresmoipInfo> translateResultHook(DeciResult<PeresmoipInfo> result) {
		return result;
	}
}
