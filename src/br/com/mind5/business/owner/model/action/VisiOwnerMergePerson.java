package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.RootPersonSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

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
