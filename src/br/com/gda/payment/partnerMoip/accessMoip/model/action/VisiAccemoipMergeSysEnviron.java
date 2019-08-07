package br.com.gda.payment.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipMerger;

final class VisiAccemoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<AccemoipInfo, SysEnvironInfo> {
	
	public VisiAccemoipMergeSysEnviron(Connection conn, String schemaName) {
		super(conn, schemaName, SysEnvironInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> mergeHook(List<AccemoipInfo> recordInfos, List<SysEnvironInfo> selectedInfos) {	
		return AccemoipMerger.mergeWithSysEnviron(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
