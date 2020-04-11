package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class LazyRefumoipEnforceSetupNonsys extends ActionLazyTemplateV1<RefumoipInfo, RefumoipInfo> {

	public LazyRefumoipEnforceSetupNonsys(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefumoipInfo> translateRecordInfosHook(List<RefumoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefumoipInfo> getInstanceOfActionHook(DeciTreeOption<RefumoipInfo> option) {
		return new StdRefumoipEnforceSetupNonsys(option);
	}
	
	
	
	@Override protected DeciResult<RefumoipInfo> translateResultHook(DeciResult<RefumoipInfo> result) {
		return result;
	}
}
