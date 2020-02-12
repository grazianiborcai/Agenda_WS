package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.creditCard.model.decisionTree.RootCrecardSelect;

final class VisiCrecardMergeToDelete extends ActionVisitorTemplateMergeV2<CrecardInfo, CrecardInfo> {
	
	public VisiCrecardMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return RootCrecardSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return CrecardMerger.mergeToDelete( baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
