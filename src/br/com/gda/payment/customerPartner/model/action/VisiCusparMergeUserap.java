package br.com.gda.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserapCopier;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserapSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.info.CusparMerger;

final class VisiCusparMergeUserap extends ActionVisitorTemplateMergeV2<CusparInfo, UserapInfo> {
	
	public VisiCusparMergeUserap(Connection conn, String schemaName) {
		super(conn, schemaName, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserapInfo>> getTreeClassHook() {
		return RootUserapSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> toActionClassHook(List<CusparInfo> recordInfos) {
		return UserapCopier.copyFromCuspar(recordInfos);
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> recordInfos, List<UserapInfo> selectedInfos) {	
		return CusparMerger.mergeWithUserap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
