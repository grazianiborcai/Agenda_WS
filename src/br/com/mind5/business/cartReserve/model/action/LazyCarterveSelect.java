package br.com.mind5.business.cartReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCarterveSelect extends ActionLazyTemplateV1<CarterveInfo, CarterveInfo> {

	public LazyCarterveSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CarterveInfo> translateRecordInfosHook(List<CarterveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CarterveInfo> getInstanceOfActionHook(DeciTreeOption<CarterveInfo> option) {
		return new StdCarterveSelect(option);
	}
	
	
	
	@Override protected DeciResult<CarterveInfo> translateResultHook(DeciResult<CarterveInfo> result) {
		return result;
	}
}
