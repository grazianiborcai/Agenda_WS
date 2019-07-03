package br.com.gda.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapCopier;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrderItem.info.PayordemMerger;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class VisiOrderemMergeMatsnap extends ActionVisitorTemplateMergeV2<PayordemInfo, MatsnapInfo> {
	
	public VisiOrderemMergeMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<PayordemInfo> recordInfos) {
		return MatsnapCopier.copyFromOrderem(recordInfos);	
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> recordInfos, List<MatsnapInfo> selectedInfos) {	
		return PayordemMerger.mergeWithMatsnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
