package br.com.mind5.business.cartReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCarterveMergeToSelect extends ActionLazyTemplate<CarterveInfo, CarterveInfo> {

	public LazyCarterveMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CarterveInfo> translateRecordInfosHook(List<CarterveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<CarterveInfo> getInstanceOfActionHook(DeciTreeOption<CarterveInfo> option) {
		return new StdCarterveMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<CarterveInfo> translateResultHook(DeciResult<CarterveInfo> result) {
		return result;
	}
}
