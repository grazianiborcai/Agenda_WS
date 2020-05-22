package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.RootSysenvSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipMerger;

final class VisiAccemoipMergeSysenv extends ActionVisitorTemplateMergeV1<AccemoipInfo, SysenvInfo> {
	
	public VisiAccemoipMergeSysenv(Connection conn, String schemaName) {
		super(conn, schemaName, SysenvInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return RootSysenvSelect.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> mergeHook(List<AccemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return AccemoipMerger.mergeWithSysenv(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
