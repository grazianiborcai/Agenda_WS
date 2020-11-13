package br.com.mind5.business.cartReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCarterveSelect extends ActionLazyTemplate<CarterveInfo, CarterveInfo> {

	public LazyCarterveSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CarterveInfo> translateRecordInfosHook(List<CarterveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CarterveInfo> getInstanceOfActionHook(DeciTreeOption<CarterveInfo> option) {
		return new StdCarterveDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<CarterveInfo> translateResultHook(DeciResult<CarterveInfo> result) {
		return result;
	}
}
