package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.RootSysenvSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipMerger;

final class VisiPaymoipMergeSysenv extends ActionVisitorTemplateMergeV1<PaymoipInfo, SysenvInfo> {
	
	public VisiPaymoipMergeSysenv(Connection conn, String schemaName) {
		super(conn, schemaName, SysenvInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return RootSysenvSelect.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithSysenv(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
