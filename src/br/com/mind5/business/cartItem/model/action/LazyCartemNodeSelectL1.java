package br.com.mind5.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.NodeCartemSelectL1;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartemNodeSelectL1 extends ActionLazyTemplate<CartemInfo, CartemInfo> {
	
	public LazyCartemNodeSelectL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartemInfo> translateRecordInfosHook(List<CartemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartemInfo> getInstanceOfActionHook(DeciTreeOption<CartemInfo> option) {
		return new NodeCartemSelectL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartemInfo> translateResultHook(DeciResult<CartemInfo> result) {
		return result;
	}
}
