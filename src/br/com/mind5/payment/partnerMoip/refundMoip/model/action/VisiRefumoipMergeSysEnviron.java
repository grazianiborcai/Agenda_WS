package br.com.mind5.payment.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipMerger;

final class VisiRefumoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<RefumoipInfo, SysEnvironInfo> {
	
	public VisiRefumoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName, SysEnvironInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> recordInfos, List<SysEnvironInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithSysEnviron(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
