package br.com.gda.payment.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.accessMoip.info.AccemoipMerger;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.gda.payment.systemPartner.model.decisionTree.RootSysparSelect;

final class VisiAccemoipMergeSyspar extends ActionVisitorTemplateMergeV2<AccemoipInfo, SysparInfo> {
	
	public VisiAccemoipMergeSyspar(Connection conn, String schemaName) {
		super(conn, schemaName, SysparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysparInfo>> getTreeClassHook() {
		return RootSysparSelect.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> mergeHook(List<AccemoipInfo> recordInfos, List<SysparInfo> selectedInfos) {	
		return AccemoipMerger.mergeWithSyspar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
