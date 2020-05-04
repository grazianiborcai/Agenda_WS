package br.com.mind5.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class LazyRefuMergeOrdist extends ActionLazyTemplateV2<RefuInfo, RefuInfo> {
	
	public LazyRefuMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefuInfo> translateRecordInfosHook(List<RefuInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefuInfo> getInstanceOfActionHook(DeciTreeOption<RefuInfo> option) {
		return new StdRefuMergeOrdist(option);
	}
	
	
	
	@Override protected DeciResult<RefuInfo> translateResultHook(DeciResult<RefuInfo> result) {
		return result;
	}
}
