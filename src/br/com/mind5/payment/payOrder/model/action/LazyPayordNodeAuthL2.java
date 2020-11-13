package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.NodePayordAuthL2;

public final class LazyPayordNodeAuthL2 extends ActionLazyTemplate<PayordInfo, PayordInfo> {
	
	public LazyPayordNodeAuthL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordInfo> translateRecordInfosHook(List<PayordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordInfo> getInstanceOfActionHook(DeciTreeOption<PayordInfo> option) {
		return new NodePayordAuthL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayordInfo> translateResultHook(DeciResult<PayordInfo> result) {
		return result;
	}
}
