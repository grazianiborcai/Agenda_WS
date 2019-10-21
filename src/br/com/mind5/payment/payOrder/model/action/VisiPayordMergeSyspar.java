package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.decisionTree.RootSysparSelect;

final class VisiPayordMergeSyspar extends ActionVisitorTemplateMergeV2<PayordInfo, SysparInfo> {
	
	public VisiPayordMergeSyspar(Connection conn, String schemaName) {
		super(conn, schemaName, SysparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysparInfo>> getTreeClassHook() {
		return RootSysparSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<SysparInfo> selectedInfos) {	
		return PayordMerger.mergeWithSyspar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
