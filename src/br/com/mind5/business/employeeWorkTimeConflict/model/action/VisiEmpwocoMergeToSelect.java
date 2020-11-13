package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwocoMergeToSelect extends ActionVisitorTemplateMerge<EmpwocoInfo, EmpwocoInfo> {
	
	public VisiEmpwocoMergeToSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwocoInfo>> getActionClassHook() {
		return StdEmpwocoDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwocoInfo> mergeHook(List<EmpwocoInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwocoMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
