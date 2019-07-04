package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.creditCard.info.CrecardCopier;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.decisionTree.RootCrecardSelect;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;

final class VisiPayordMergeCrecard extends ActionVisitorTemplateMergeV2<PayordInfo, CrecardInfo> {
	
	public VisiPayordMergeCrecard(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return RootCrecardSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return CrecardCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<CrecardInfo> selectedInfos) {	
		return PayordMerger.mergeWithCrecard(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
