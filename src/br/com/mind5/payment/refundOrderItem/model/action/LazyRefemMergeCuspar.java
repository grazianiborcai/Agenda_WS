package br.com.mind5.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class LazyRefemMergeCuspar extends ActionLazyTemplateV2<RefemInfo, RefemInfo> {
	
	public LazyRefemMergeCuspar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefemInfo> translateRecordInfosHook(List<RefemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefemInfo> getInstanceOfActionHook(DeciTreeOption<RefemInfo> option) {
		return new StdRefemMergeCuspar(option);
	}
	
	
	
	@Override protected DeciResult<RefemInfo> translateResultHook(DeciResult<RefemInfo> result) {
		return result;
	}
}
