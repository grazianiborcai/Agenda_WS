package br.com.gda.security.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonapCopier;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userSnapshot.info.UserapInfo;
import br.com.gda.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergePersonap extends ActionVisitorTemplateMergeV2<UserapInfo, PersonapInfo> {
	
	public VisiUserapMergePersonap(Connection conn, String schemaName) {
		super(conn, schemaName, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return RootPersonapSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<UserapInfo> recordInfos) {
		return PersonapCopier.copyFromUserapKey(recordInfos);
	}	
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> recordInfos, List<PersonapInfo> selectedInfos) {	
		return UserapMerger.mergeWithPersonap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
