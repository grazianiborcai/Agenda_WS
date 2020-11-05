package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmMergeEmpwout extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwoutInfo> {
	
	public VisiEmpwotmMergeEmpwout(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwoutInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwoutInfo>> getTreeClassHook() {
		return RootEmpwoutSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwout(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
