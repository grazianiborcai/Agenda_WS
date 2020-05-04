package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class LazyPayordMergeCrecard extends ActionLazyTemplateV2<PayordInfo, PayordInfo> {
	
	public LazyPayordMergeCrecard(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordInfo> translateRecordInfosHook(List<PayordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PayordInfo> getInstanceOfActionHook(DeciTreeOption<PayordInfo> option) {
		return new StdPayordMergeCrecard(option);
	}
	
	
	
	@Override protected DeciResult<PayordInfo> translateResultHook(DeciResult<PayordInfo> result) {
		return result;
	}
}
