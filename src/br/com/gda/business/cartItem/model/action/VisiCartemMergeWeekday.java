package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.info.CartemMerger;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartemMergeWeekday extends ActionVisitorTemplateMergeV2<CartemInfo, WeekdayInfo> {
	
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
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
