package br.com.gda.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatCopier;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleMonth.info.SchedmonMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedmonMergeMat extends ActionVisitorTemplateMergeV2<SchedmonInfo, MatInfo> {
	
	public VisiSchedmonMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return MatCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
