package br.com.gda.payService.payPartnerOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.model.decisionTree.NodePayparOwnerSelectL1;

public final class LazyPayparOwnerNodeSelectL1 extends ActionLazyTemplate<PayparOwnerInfo, PayparOwnerInfo> {
	
	public LazyPayparOwnerNodeSelectL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayparOwnerInfo> translateRecordInfosHook(List<PayparOwnerInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayparOwnerInfo> getInstanceOfActionHook(DeciTreeOption<PayparOwnerInfo> option) {
		return new NodePayparOwnerSelectL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayparOwnerInfo> translateResultHook(DeciResult<PayparOwnerInfo> result) {
		return result;
	}
}
