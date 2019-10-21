package br.com.mind5.business.personSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootGenderSelect;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPersonapMergeGender extends ActionVisitorTemplateMergeV2<PersonapInfo, GenderInfo> {
	
	public VisiPersonapMergeGender(Connection conn, String schemaName) {
		super(conn, schemaName, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return RootGenderSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> mergeHook(List<PersonapInfo> recordInfos, List<GenderInfo> selectedInfos) {	
		return PersonapMerger.mergeWithGender(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
