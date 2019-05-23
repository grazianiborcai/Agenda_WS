package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCartemDelete extends ActionLazyTemplate<CartemInfo, CartemInfo> {
	
	public LazyCartemDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartemInfo> translateRecordInfosHook(List<CartemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartemInfo> getInstanceOfActionHook(DeciTreeOption<CartemInfo> option) {
		return new StdCartemDeleteItm(option);
	}
	
	
	
	@Override protected DeciResult<CartemInfo> translateResultHook(DeciResult<CartemInfo> result) {
		return result;
	}
}
