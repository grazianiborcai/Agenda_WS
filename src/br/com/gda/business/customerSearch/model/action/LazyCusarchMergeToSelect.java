package br.com.gda.business.customerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCusarchMergeToSelect extends ActionLazyTemplate<CusarchInfo, CusarchInfo> {
	
	public LazyCusarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusarchInfo> translateRecordInfosHook(List<CusarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusarchInfo> getInstanceOfActionHook(DeciTreeOption<CusarchInfo> option) {
		return new StdCusarchMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<CusarchInfo> translateResultHook(DeciResult<CusarchInfo> result) {
		return result;
	}
}
