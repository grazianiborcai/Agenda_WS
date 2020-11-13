package br.com.mind5.business.employeeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmparchMergeToSelect extends ActionVisitorTemplateMerge<EmparchInfo, EmparchInfo> {
	
	public VisiEmparchMergeToSelect(DeciTreeOption<EmparchInfo> option) {
		super(option, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmparchInfo>> getActionClassHook() {
		return StdEmparchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmparchInfo> mergeHook(List<EmparchInfo> baseInfos, List<EmparchInfo> selectedInfos) {	
		return EmparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
