package br.com.gda.payment.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class LazyRefumoipEnforceResponseAttr extends ActionLazyTemplate<RefumoipInfo, RefumoipInfo> {

	public LazyRefumoipEnforceResponseAttr(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefumoipInfo> translateRecordInfosHook(List<RefumoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefumoipInfo> getInstanceOfActionHook(DeciTreeOption<RefumoipInfo> option) {
		return new StdRefumoipEnforceResponseAttr(option);
	}
	
	
	
	@Override protected DeciResult<RefumoipInfo> translateResultHook(DeciResult<RefumoipInfo> result) {
		return result;
	}
}
