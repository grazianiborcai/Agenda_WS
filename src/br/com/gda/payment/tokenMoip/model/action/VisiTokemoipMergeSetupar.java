package br.com.gda.payment.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.tokenMoip.info.TokemoipMerger;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiTokemoipMergeSetupar extends ActionVisitorTemplateMergeV2<TokemoipInfo, SetuparInfo> {
	
	public VisiTokemoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<TokemoipInfo> mergeHook(List<TokemoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return TokemoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
