package br.com.mind5.payment.statusPayOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class LazyPaytusemPayordemUpdate extends ActionLazyTemplate<PaytusemInfo, PaytusemInfo> {
	
	public LazyPaytusemPayordemUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaytusemInfo> translateRecordInfosHook(List<PaytusemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaytusemInfo> getInstanceOfActionHook(DeciTreeOption<PaytusemInfo> option) {
		return new StdPaytusemPayordemUpdate(option);
	}
	
	
	
	@Override protected DeciResult<PaytusemInfo> translateResultHook(DeciResult<PaytusemInfo> result) {
		return result;
	}
}
