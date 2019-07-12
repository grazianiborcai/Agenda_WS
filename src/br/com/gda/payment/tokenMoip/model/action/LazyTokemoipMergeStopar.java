package br.com.gda.payment.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

public final class LazyTokemoipMergeStopar extends ActionLazyTemplate<TokemoipInfo, TokemoipInfo> {
	
	public LazyTokemoipMergeStopar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<TokemoipInfo> translateRecordInfosHook(List<TokemoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<TokemoipInfo> getInstanceOfActionHook(DeciTreeOption<TokemoipInfo> option) {
		return new StdTokemoipMergeStopar(option);
	}
	
	
	
	@Override protected DeciResult<TokemoipInfo> translateResultHook(DeciResult<TokemoipInfo> result) {
		return result;
	}
}
