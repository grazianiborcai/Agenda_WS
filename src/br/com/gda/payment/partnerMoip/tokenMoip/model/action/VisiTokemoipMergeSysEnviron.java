package br.com.gda.payment.partnerMoip.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipMerger;

final class VisiTokemoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<TokemoipInfo, SysEnvironInfo> {
	
	public VisiTokemoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName, SysEnvironInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<TokemoipInfo> mergeHook(List<TokemoipInfo> recordInfos, List<SysEnvironInfo> selectedInfos) {	
		return TokemoipMerger.mergeWithSysEnviron(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
