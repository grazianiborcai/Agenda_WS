package br.com.mind5.message.emailWelcome.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.info.EmacomeMerger;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.RootOwnelisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmacomeMergeOwnelis extends ActionVisitorTemplateMerge<EmacomeInfo, OwnelisInfo> {
	
	public VisiEmacomeMergeOwnelis(Connection conn, String schemaName) {
		super(conn, schemaName, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return RootOwnelisSelect.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> mergeHook(List<EmacomeInfo> recordInfos, List<OwnelisInfo> selectedInfos) {	
		return EmacomeMerger.mergeWithOwnelis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
