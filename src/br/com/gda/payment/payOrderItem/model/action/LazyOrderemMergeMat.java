package br.com.gda.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class LazyOrderemMergeMat extends ActionLazyTemplate<PayordemInfo, PayordemInfo> {
	
	public LazyOrderemMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordemInfo> translateRecordInfosHook(List<PayordemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordemInfo> getInstanceOfActionHook(DeciTreeOption<PayordemInfo> option) {
		return new StdOrderemMergeMat(option);
	}
	
	
	
	@Override protected DeciResult<PayordemInfo> translateResultHook(DeciResult<PayordemInfo> result) {		
		return result;
	}
}
