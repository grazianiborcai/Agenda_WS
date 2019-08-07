package br.com.gda.payment.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class LazyRefumoipMergeSysEnviron extends ActionLazyTemplate<RefumoipInfo, RefumoipInfo> {

	public LazyRefumoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefumoipInfo> translateRecordInfosHook(List<RefumoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefumoipInfo> getInstanceOfActionHook(DeciTreeOption<RefumoipInfo> option) {
		return new StdRefumoipMergeSysEnviron(option);
	}
	
	
	
	@Override protected DeciResult<RefumoipInfo> translateResultHook(DeciResult<RefumoipInfo> result) {
		return result;
	}
}
