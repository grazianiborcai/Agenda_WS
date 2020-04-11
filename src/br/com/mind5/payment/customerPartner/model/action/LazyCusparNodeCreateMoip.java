package br.com.mind5.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.NodeCusparCreateCusmoip;

public final class LazyCusparNodeCreateMoip extends ActionLazyTemplateV1<CusparInfo, CusparInfo> {

	public LazyCusparNodeCreateMoip(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusparInfo> translateRecordInfosHook(List<CusparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CusparInfo> getInstanceOfActionHook(DeciTreeOption<CusparInfo> option) {
		return new NodeCusparCreateCusmoip(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusparInfo> translateResultHook(DeciResult<CusparInfo> result) {
		return result;
	}
}
