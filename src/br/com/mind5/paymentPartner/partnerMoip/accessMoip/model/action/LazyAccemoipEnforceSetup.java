package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class LazyAccemoipEnforceSetup extends ActionLazyTemplate<AccemoipInfo, AccemoipInfo> {
	
	public LazyAccemoipEnforceSetup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AccemoipInfo> translateRecordInfosHook(List<AccemoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<AccemoipInfo> getInstanceOfActionHook(DeciTreeOption<AccemoipInfo> option) {
		return new StdAccemoipEnforceSetup(option);
	}
	
	
	
	@Override protected DeciResult<AccemoipInfo> translateResultHook(DeciResult<AccemoipInfo> result) {
		return result;
	}
}
