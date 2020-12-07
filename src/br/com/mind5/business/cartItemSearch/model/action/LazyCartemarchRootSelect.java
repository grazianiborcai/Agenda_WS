package br.com.mind5.business.cartItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.RootCartemarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartemarchRootSelect extends ActionLazyTemplate<CartemarchInfo, CartemarchInfo> {
	
	public LazyCartemarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartemarchInfo> translateRecordInfosHook(List<CartemarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartemarchInfo> getInstanceOfActionHook(DeciTreeOption<CartemarchInfo> option) {
		return new RootCartemarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartemarchInfo> translateResultHook(DeciResult<CartemarchInfo> result) {
		return result;
	}
}
