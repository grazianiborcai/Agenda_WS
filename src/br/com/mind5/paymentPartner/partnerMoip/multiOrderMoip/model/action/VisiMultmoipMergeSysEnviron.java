package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;

final class VisiMultmoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<MultmoipInfo, SysEnvironInfo> {
	
	public VisiMultmoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName, SysEnvironInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<MultmoipInfo> mergeHook(List<MultmoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {	
		return MultmoipMerger.mergeWithSysEnviron(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
