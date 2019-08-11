package br.com.gda.business.schedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapCopier;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.OrderemMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderemMergeMatsnap extends ActionVisitorTemplateMergeV2<ScheduInfo, MatsnapInfo> {
	
	public VisiOrderemMergeMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<ScheduInfo> recordInfos) {
		return MatsnapCopier.copyFromOrderem(recordInfos);	
	}
	
	
	
	@Override protected List<ScheduInfo> mergeHook(List<ScheduInfo> recordInfos, List<MatsnapInfo> selectedInfos) {	
		return OrderemMerger.mergeWithMatsnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
