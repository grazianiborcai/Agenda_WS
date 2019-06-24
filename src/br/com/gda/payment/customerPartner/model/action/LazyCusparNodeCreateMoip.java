package br.com.gda.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.decisionTree.NodeCusparCreateCusmoip;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCusparNodeCreateMoip extends ActionLazyTemplate<CusparInfo, CusparInfo> {

	public LazyCusparNodeCreateMoip(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusparInfo> translateRecordInfosHook(List<CusparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusparInfo> getInstanceOfActionHook(DeciTreeOption<CusparInfo> option) {
		return new NodeCusparCreateCusmoip(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusparInfo> translateResultHook(DeciResult<CusparInfo> result) {
		return result;
	}
}
