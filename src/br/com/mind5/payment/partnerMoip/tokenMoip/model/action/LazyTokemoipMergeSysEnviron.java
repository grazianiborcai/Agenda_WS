package br.com.mind5.payment.partnerMoip.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class LazyTokemoipMergeSysEnviron extends ActionLazyTemplate<TokemoipInfo, TokemoipInfo> {
	
	public LazyTokemoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<TokemoipInfo> translateRecordInfosHook(List<TokemoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<TokemoipInfo> getInstanceOfActionHook(DeciTreeOption<TokemoipInfo> option) {
		return new StdTokemoipMergeSysEnviron(option);
	}
	
	
	
	@Override protected DeciResult<TokemoipInfo> translateResultHook(DeciResult<TokemoipInfo> result) {
		return result;
	}
}
