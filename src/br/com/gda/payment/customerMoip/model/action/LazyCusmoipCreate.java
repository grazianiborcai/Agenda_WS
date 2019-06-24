package br.com.gda.payment.customerMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;

public final class LazyCusmoipCreate extends ActionLazyTemplate<CusmoipInfo, CusmoipInfo> {

	public LazyCusmoipCreate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusmoipInfo> translateRecordInfosHook(List<CusmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusmoipInfo> getInstanceOfActionHook(DeciTreeOption<CusmoipInfo> option) {
		return new StdCusmoipCreate(option);
	}
	
	
	
	@Override protected DeciResult<CusmoipInfo> translateResultHook(DeciResult<CusmoipInfo> result) {
		return result;
	}
}
