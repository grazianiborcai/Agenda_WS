package br.com.mind5.business.feeDefault.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFeedefSelect extends ActionLazyTemplateV1<FeedefInfo, FeedefInfo> {

	public LazyFeedefSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeedefInfo> translateRecordInfosHook(List<FeedefInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<FeedefInfo> getInstanceOfActionHook(DeciTreeOption<FeedefInfo> option) {
		return new StdFeedefSelect(option);
	}
	
	
	
	@Override protected DeciResult<FeedefInfo> translateResultHook(DeciResult<FeedefInfo> result) {
		return result;
	}
}
