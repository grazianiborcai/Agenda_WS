package br.com.mind5.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class LazyPayordemInsert extends ActionLazyTemplate<PayordemInfo, PayordemInfo> {
	
	public LazyPayordemInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordemInfo> translateRecordInfosHook(List<PayordemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordemInfo> getInstanceOfActionHook(DeciTreeOption<PayordemInfo> option) {
		return new StdPayordemInsert(option);
	}
	
	
	
	@Override protected DeciResult<PayordemInfo> translateResultHook(DeciResult<PayordemInfo> result) {
		return result;
	}
}
