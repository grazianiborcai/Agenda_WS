package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmMergeToSelect extends ActionVisitorTemplateMerge<EmpwotmInfo, EmpwotmInfo> {
	
	public VisiEmpwotmMergeToSelect(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwotmInfo>> getActionClassHook() {
		return StdEmpwotmDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {	
		return EmpwotmMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
