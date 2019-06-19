package br.com.gda.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class LazyCusparInsert extends ActionLazyTemplate<CusparInfo, CusparInfo> {

	public LazyCusparInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusparInfo> translateRecordInfosHook(List<CusparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusparInfo> getInstanceOfActionHook(DeciTreeOption<CusparInfo> option) {
		return new StdCusparInsert(option);
	}
	
	
	
	@Override protected DeciResult<CusparInfo> translateResultHook(DeciResult<CusparInfo> result) {
		return result;
	}
}
