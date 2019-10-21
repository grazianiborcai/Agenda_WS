package br.com.mind5.payment.countryPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.info.CounparMerger;

final class VisiCounparMergePaypar extends ActionVisitorTemplateMergeV2<CounparInfo, PayparInfo> {
	
	public VisiCounparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected List<CounparInfo> mergeHook(List<CounparInfo> recordInfos, List<PayparInfo> selectedInfos) {
		return CounparMerger.mergeWithPaypar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
