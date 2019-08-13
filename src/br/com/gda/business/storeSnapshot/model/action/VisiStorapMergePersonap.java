package br.com.gda.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonapCopier;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.info.StorapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStorapMergePersonap extends ActionVisitorTemplateMergeV2<StorapInfo, PersonapInfo> {
	
	public VisiStorapMergePersonap(Connection conn, String schemaName) {
		super(conn, schemaName, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return RootPersonapSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<StorapInfo> recordInfos) {
		return PersonapCopier.copyFromStorap(recordInfos);
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<PersonapInfo> selectedInfos) {	
		return StorapMerger.mergeWithPersonap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}	
}
