package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatCopier;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedineMergeMat extends ActionVisitorTemplateMergeV2<SchedineInfo, MatInfo> {
	
	public VisiSchedineMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<SchedineInfo> recordInfos) {
		return MatCopier.copyFromSchedine(recordInfos);	
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return SchedineMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
