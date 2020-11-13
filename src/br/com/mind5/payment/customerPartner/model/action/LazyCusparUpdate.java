package br.com.mind5.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class LazyCusparUpdate extends ActionLazyTemplate<CusparInfo, CusparInfo> {

	public LazyCusparUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusparInfo> translateRecordInfosHook(List<CusparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusparInfo> getInstanceOfActionHook(DeciTreeOption<CusparInfo> option) {
		return new StdCusparDaoUpdate(option);
	}
	
	
	
	@Override protected DeciResult<CusparInfo> translateResultHook(DeciResult<CusparInfo> result) {
		return result;
	}
}
