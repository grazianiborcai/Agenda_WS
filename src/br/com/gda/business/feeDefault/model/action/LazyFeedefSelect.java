package br.com.gda.business.feeDefault.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFeedefSelect extends ActionLazyTemplate<FeedefInfo, FeedefInfo> {

	public LazyFeedefSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeedefInfo> translateRecordInfosHook(List<FeedefInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FeedefInfo> getInstanceOfActionHook(DeciTreeOption<FeedefInfo> option) {
		return new StdFeedefSelect(option);
	}
	
	
	
	@Override protected DeciResult<FeedefInfo> translateResultHook(DeciResult<FeedefInfo> result) {
		return result;
	}
}
