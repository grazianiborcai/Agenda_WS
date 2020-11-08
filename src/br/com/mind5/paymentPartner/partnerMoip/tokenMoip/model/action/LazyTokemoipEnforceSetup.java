package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class LazyTokemoipEnforceSetup extends ActionLazyTemplateV2<TokemoipInfo, TokemoipInfo> {
	
	public LazyTokemoipEnforceSetup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<TokemoipInfo> translateRecordInfosHook(List<TokemoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<TokemoipInfo> getInstanceOfActionHook(DeciTreeOption<TokemoipInfo> option) {
		return new StdTokemoipEnforceSetup(option);
	}
	
	
	
	@Override protected DeciResult<TokemoipInfo> translateResultHook(DeciResult<TokemoipInfo> result) {
		return result;
	}
}
