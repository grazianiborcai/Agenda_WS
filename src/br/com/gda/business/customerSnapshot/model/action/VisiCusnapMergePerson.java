package br.com.gda.business.customerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.business.customerSnapshot.info.CusnapMerger;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusnapMergePerson extends ActionVisitorTemplateMergeV2<CusnapInfo, PersonInfo> {
	
	public VisiCusnapMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> recordInfos, List<PersonInfo> selectedInfos) {	
		return CusnapMerger.mergeWithPerson(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
