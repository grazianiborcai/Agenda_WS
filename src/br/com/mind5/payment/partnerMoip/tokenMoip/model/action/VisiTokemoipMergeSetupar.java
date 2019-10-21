package br.com.mind5.payment.partnerMoip.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipMerger;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

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
