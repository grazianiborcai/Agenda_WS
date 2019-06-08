package br.com.gda.business.cartReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCarterveSelect extends ActionLazyTemplate<CarterveInfo, CarterveInfo> {

	public LazyCarterveSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CarterveInfo> translateRecordInfosHook(List<CarterveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CarterveInfo> getInstanceOfActionHook(DeciTreeOption<CarterveInfo> option) {
		return new StdCarterveSelect(option);
	}
	
	
	
	@Override protected DeciResult<CarterveInfo> translateResultHook(DeciResult<CarterveInfo> result) {
		return result;
	}
}
