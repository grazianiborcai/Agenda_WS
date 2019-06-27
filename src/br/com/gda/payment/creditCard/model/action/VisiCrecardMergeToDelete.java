package br.com.gda.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.info.CrecardMerger;
import br.com.gda.payment.creditCard.model.decisionTree.RootCrecardSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCrecardMergeToDelete extends ActionVisitorTemplateMergeV2<CrecardInfo, CrecardInfo> {
	
	public VisiCrecardMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return RootCrecardSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> recordInfos, List<CrecardInfo> selectedInfos) {	
		return CrecardMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
