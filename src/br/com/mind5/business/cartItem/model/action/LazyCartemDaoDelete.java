package br.com.mind5.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartemDaoDelete extends ActionLazyTemplate<CartemInfo, CartemInfo> {
	
	public LazyCartemDaoDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartemInfo> translateRecordInfosHook(List<CartemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CartemInfo> getInstanceOfActionHook(DeciTreeOption<CartemInfo> option) {
		return new StdCartemDaoDelete(option);
	}
	
	
	
	@Override protected DeciResult<CartemInfo> translateResultHook(DeciResult<CartemInfo> result) {
		return result;
	}
}
