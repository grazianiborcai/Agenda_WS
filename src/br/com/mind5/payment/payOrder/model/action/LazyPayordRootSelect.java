package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.RootPayordSelect;

public final class LazyPayordRootSelect extends ActionLazyTemplateV1<PayordInfo, PayordInfo> {
	
	public LazyPayordRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordInfo> translateRecordInfosHook(List<PayordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PayordInfo> getInstanceOfActionHook(DeciTreeOption<PayordInfo> option) {
		return new RootPayordSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayordInfo> translateResultHook(DeciResult<PayordInfo> result) {
		return result;
	}
}
