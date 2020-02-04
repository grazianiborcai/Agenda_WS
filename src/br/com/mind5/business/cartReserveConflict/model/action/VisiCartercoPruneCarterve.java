package br.com.mind5.business.cartReserveConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCartercoPruneCarterve extends ActionVisitorTemplatePrune<CartercoInfo, CarterveInfo> {
	
	public VisiCartercoPruneCarterve(Connection conn, String schemaName) {
		super(conn, schemaName, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return RootCarterveSelect.class;
	}
	
	
	
	@Override protected List<CartercoInfo> pruneHook(List<CartercoInfo> recordInfos, List<CarterveInfo> selectedInfos) {	
		return CartercoPruner.pruneWithCarterve(recordInfos, selectedInfos);
	}
}
