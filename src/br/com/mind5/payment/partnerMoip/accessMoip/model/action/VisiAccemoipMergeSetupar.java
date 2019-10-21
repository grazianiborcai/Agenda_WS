package br.com.mind5.payment.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipMerger;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiAccemoipMergeSetupar extends ActionVisitorTemplateMergeV2<AccemoipInfo, SetuparInfo> {
	
	public VisiAccemoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> mergeHook(List<AccemoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return AccemoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
