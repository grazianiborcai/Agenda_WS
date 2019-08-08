package br.com.gda.payment.partnerMoip.multiPayMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class LazyPaymoipRead extends ActionLazyTemplate<PaymoipInfo, PaymoipInfo> {

	public LazyPaymoipRead(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaymoipInfo> translateRecordInfosHook(List<PaymoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaymoipInfo> getInstanceOfActionHook(DeciTreeOption<PaymoipInfo> option) {
		return new StdPaymoipRead(option);
	}
	
	
	
	@Override protected DeciResult<PaymoipInfo> translateResultHook(DeciResult<PaymoipInfo> result) {
		return result;
	}
}
