package br.com.mind5.business.feeDefault.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFeedefSelect extends ActionLazyTemplate<FeedefInfo, FeedefInfo> {

	public LazyFeedefSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeedefInfo> translateRecordInfosHook(List<FeedefInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FeedefInfo> getInstanceOfActionHook(DeciTreeOption<FeedefInfo> option) {
		return new StdFeedefDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<FeedefInfo> translateResultHook(DeciResult<FeedefInfo> result) {
		return result;
	}
}
