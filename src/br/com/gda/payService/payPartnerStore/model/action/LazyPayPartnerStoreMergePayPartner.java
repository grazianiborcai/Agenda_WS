package br.com.gda.payService.payPartnerStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;

public final class LazyPayPartnerStoreMergePayPartner extends ActionLazyTemplate<PayPartnerStoreInfo, PayPartnerStoreInfo> {
	
	public LazyPayPartnerStoreMergePayPartner(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayPartnerStoreInfo> translateRecordInfosHook(List<PayPartnerStoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayPartnerStoreInfo> getInstanceOfActionHook(DeciTreeOption<PayPartnerStoreInfo> option) {
		return new StdPayPartnerStoreMergePayPartner(option);
	}
	
	
	
	@Override protected DeciResult<PayPartnerStoreInfo> translateResultHook(DeciResult<PayPartnerStoreInfo> result) {
		return result;
	}
}
