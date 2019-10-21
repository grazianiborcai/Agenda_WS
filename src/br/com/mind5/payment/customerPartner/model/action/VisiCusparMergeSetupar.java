package br.com.mind5.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiCusparMergeSetupar extends ActionVisitorTemplateMergeV2<CusparInfo, SetuparInfo> {
	
	public VisiCusparMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return CusparMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
