package br.com.mind5.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCartemMergeWeekday extends ActionVisitorTemplateMerge<CartemInfo, WeekdayInfo> {
	
	public VisiCartemMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<WeekdayInfo> selectedInfos) {	
		return CartemMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
