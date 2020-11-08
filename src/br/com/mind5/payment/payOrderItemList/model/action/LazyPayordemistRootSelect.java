package br.com.mind5.payment.payOrderItemList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.RootPayordemistSelect;

public final class LazyPayordemistRootSelect extends ActionLazyTemplateV2<PayordemistInfo, PayordemistInfo> {
	
	public LazyPayordemistRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordemistInfo> translateRecordInfosHook(List<PayordemistInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PayordemistInfo> getInstanceOfActionHook(DeciTreeOption<PayordemistInfo> option) {
		return new RootPayordemistSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayordemistInfo> translateResultHook(DeciResult<PayordemistInfo> result) {
		return result;
	}
}
