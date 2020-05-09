package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.RootPayormarchSelect;

public final class LazyPayormarchRootSelect extends ActionLazyTemplateV2<PayormarchInfo, PayormarchInfo> {
	
	public LazyPayormarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayormarchInfo> translateRecordInfosHook(List<PayormarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PayormarchInfo> getInstanceOfActionHook(DeciTreeOption<PayormarchInfo> option) {
		return new RootPayormarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayormarchInfo> translateResultHook(DeciResult<PayormarchInfo> result) {
		return result;
	}
}
