package br.com.mind5.payment.partnerMoip.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipMerger;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.decisionTree.RootSysparSelect;

final class VisiTokemoipMergeSyspar extends ActionVisitorTemplateMergeV2<TokemoipInfo, SysparInfo> {
	
	public VisiTokemoipMergeSyspar(Connection conn, String schemaName) {
		super(conn, schemaName, SysparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysparInfo>> getTreeClassHook() {
		return RootSysparSelect.class;
	}
	
	
	
	@Override protected List<TokemoipInfo> mergeHook(List<TokemoipInfo> recordInfos, List<SysparInfo> selectedInfos) {	
		return TokemoipMerger.mergeWithSyspar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
