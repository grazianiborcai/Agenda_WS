package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class LazyRefumoipMergeSysenv extends ActionLazyTemplate<RefumoipInfo, RefumoipInfo> {

	public LazyRefumoipMergeSysenv(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefumoipInfo> translateRecordInfosHook(List<RefumoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefumoipInfo> getInstanceOfActionHook(DeciTreeOption<RefumoipInfo> option) {
		return new StdRefumoipMergeSysenv(option);
	}
	
	
	
	@Override protected DeciResult<RefumoipInfo> translateResultHook(DeciResult<RefumoipInfo> result) {
		return result;
	}
}
