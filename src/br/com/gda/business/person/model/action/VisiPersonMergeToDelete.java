package br.com.gda.business.person.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonMerger;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonMergeToDelete extends ActionVisitorTemplateMergeV2<PersonInfo, PersonInfo> {
	
	public VisiPersonMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected List<PersonInfo> mergeHook(List<PersonInfo> recordInfos, List<PersonInfo> selectedInfos) {	
		return PersonMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
