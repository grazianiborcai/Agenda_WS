package br.com.mind5.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.RootCartemarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCartemMergeCartemarch extends ActionVisitorTemplateMergeV2<CartemInfo, CartemarchInfo> {
	
	public VisiCartemMergeCartemarch(Connection conn, String schemaName) {
		super(conn, schemaName, CartemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemarchInfo>> getTreeClassHook() {
		return RootCartemarchSelect.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<CartemarchInfo> selectedInfos) {	
		return CartemMerger.mergeWithCartemarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
