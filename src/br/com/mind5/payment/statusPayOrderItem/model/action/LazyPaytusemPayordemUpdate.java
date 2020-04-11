package br.com.mind5.payment.statusPayOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class LazyPaytusemPayordemUpdate extends ActionLazyTemplateV1<PaytusemInfo, PaytusemInfo> {
	
	public LazyPaytusemPayordemUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaytusemInfo> translateRecordInfosHook(List<PaytusemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PaytusemInfo> getInstanceOfActionHook(DeciTreeOption<PaytusemInfo> option) {
		return new StdPaytusemPayordemUpdate(option);
	}
	
	
	
	@Override protected DeciResult<PaytusemInfo> translateResultHook(DeciResult<PaytusemInfo> result) {
		return result;
	}
}
