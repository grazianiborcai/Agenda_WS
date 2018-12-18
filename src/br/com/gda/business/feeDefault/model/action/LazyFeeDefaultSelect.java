package br.com.gda.business.feeDefault.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFeeDefaultSelect extends ActionLazyTemplate<FeeDefaultInfo, FeeDefaultInfo> {

	public LazyFeeDefaultSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeeDefaultInfo> translateRecordInfosHook(List<FeeDefaultInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FeeDefaultInfo> getInstanceOfActionHook(DeciTreeOption<FeeDefaultInfo> option) {
		return new StdFeeDefaultSelect(option);
	}
	
	
	
	@Override protected DeciResult<FeeDefaultInfo> translateResultHook(DeciResult<FeeDefaultInfo> result) {
		return result;
	}
}
