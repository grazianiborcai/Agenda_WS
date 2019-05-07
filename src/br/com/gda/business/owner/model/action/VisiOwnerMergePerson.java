package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergePerson extends ActionVisitorTemplateMergeV2<OwnerInfo, PersonInfo> {
	
	public VisiOwnerMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<PersonInfo> selectedInfos) {	
		return OwnerMerger.mergeWithPerson(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}	
}
