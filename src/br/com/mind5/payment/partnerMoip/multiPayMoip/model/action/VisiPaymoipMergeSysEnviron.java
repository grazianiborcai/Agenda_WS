package br.com.mind5.payment.partnerMoip.multiPayMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipMerger;

final class VisiPaymoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<PaymoipInfo, SysEnvironInfo> {
	
	public VisiPaymoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName, SysEnvironInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> recordInfos, List<SysEnvironInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithSysEnviron(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
