package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.RootCrecarchSelect;

final class VisiCrecardMergeCrecarch extends ActionVisitorTemplateMerge<CrecardInfo, CrecarchInfo> {
	
	public VisiCrecardMergeCrecarch(Connection conn, String schemaName) {
		super(conn, schemaName, CrecarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecarchInfo>> getTreeClassHook() {
		return RootCrecarchSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CrecarchInfo> selectedInfos) {	
		return CrecardMerger.mergeWithCrecarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
