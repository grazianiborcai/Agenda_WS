package br.com.gda.payment.customerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhonapSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.info.CusparMerger;

final class VisiCusparMergePhonap extends ActionVisitorTemplateMergeV2<CusparInfo, PhonapInfo> {
	
	public VisiCusparMergePhonap(Connection conn, String schemaName) {
		super(conn, schemaName, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return RootPhonapSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> recordInfos, List<PhonapInfo> selectedInfos) {	
		return CusparMerger.mergeWithPhonap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
