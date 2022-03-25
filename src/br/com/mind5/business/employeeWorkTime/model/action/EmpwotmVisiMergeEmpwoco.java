package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.EmpwocoRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmVisiMergeEmpwoco extends ActionVisitorTemplateMerge<EmpwotmInfo, EmpwocoInfo> {
	
	public EmpwotmVisiMergeEmpwoco(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwocoInfo>> getTreeClassHook() {
		return EmpwocoRootSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwoco(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
