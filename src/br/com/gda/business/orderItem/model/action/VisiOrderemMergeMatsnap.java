package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapCopier;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.info.OrderemMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderemMergeMatsnap extends ActionVisitorTemplateMergeV2<OrderemInfo, MatsnapInfo> {
	
	public VisiOrderemMergeMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<OrderemInfo> recordInfos) {
		return MatsnapCopier.copyFromOrderem(recordInfos);	
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> recordInfos, List<MatsnapInfo> selectedInfos) {	
		return OrderemMerger.mergeWithMatsnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
