package br.com.gda.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.info.StolisMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolisMergeTimezone extends ActionVisitorTemplateMerge<StolisInfo, TimezoneInfo> {
	
	public VisiStolisMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> recordInfos, List<TimezoneInfo> selectedInfos) {	
		return StolisMerger.mergeWithTimezone(selectedInfos, recordInfos);
	}
}
