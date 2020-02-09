package br.com.mind5.business.cartReserveConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCartercoMergeCarterve extends ActionVisitorTemplateMergeV2<CartercoInfo, CarterveInfo> {
	
	public VisiCartercoMergeCarterve(Connection conn, String schemaName) {
		super(conn, schemaName, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return RootCarterveSelect.class;
	}
	
	
	
	@Override protected List<CartercoInfo> mergeHook(List<CartercoInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return CartercoMerger.mergeWithCarterve(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}