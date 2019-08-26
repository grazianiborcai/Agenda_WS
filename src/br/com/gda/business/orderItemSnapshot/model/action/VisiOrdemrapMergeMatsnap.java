package br.com.gda.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapCopier;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrdemrapMergeMatsnap extends ActionVisitorTemplateMergeV2<OrdemrapInfo, MatsnapInfo> {
	
	public VisiOrdemrapMergeMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<OrdemrapInfo> recordInfos) {
		return MatsnapCopier.copyFromOrdemrap(recordInfos);	
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> recordInfos, List<MatsnapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeWithMatsnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
