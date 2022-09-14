package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.EmpwotmRootSearchEmposFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiMergeEmpwotm extends ActionVisitorTemplateMerge<EmpInfo, EmpwotmInfo> {
	
	public EmpVisiMergeEmpwotm(DeciTreeOption<EmpInfo> option) {
		super(option, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return EmpwotmRootSearchEmposFallback.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {	
		return EmpMerger.mergeWithEmpwotm(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
