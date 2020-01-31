package br.com.mind5.business.personListRestricted.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.business.personListRestricted.info.PersoresMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPersoresMergePersolis extends ActionVisitorTemplateMergeV2<PersoresInfo, PersolisInfo> {
	
	public VisiPersoresMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}
	
	
	
	@Override protected List<PersoresInfo> mergeHook(List<PersoresInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return PersoresMerger.mergeWithPersolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
