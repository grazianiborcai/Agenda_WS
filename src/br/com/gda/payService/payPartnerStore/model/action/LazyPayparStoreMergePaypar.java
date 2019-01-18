package br.com.gda.payService.payPartnerStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;

public final class LazyPayparStoreMergePaypar extends ActionLazyTemplate<PayparStoreInfo, PayparStoreInfo> {
	
	public LazyPayparStoreMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayparStoreInfo> translateRecordInfosHook(List<PayparStoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayparStoreInfo> getInstanceOfActionHook(DeciTreeOption<PayparStoreInfo> option) {
		return new StdPayparStoreMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<PayparStoreInfo> translateResultHook(DeciResult<PayparStoreInfo> result) {
		return result;
	}
}
