package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwocoVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpwocoInfo, EmpwocoInfo> {
	
	public EmpwocoVisiMergeToSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpwocoInfo>> getVisitorClassHook() {
		return EmpwocoVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwocoInfo> mergeHook(List<EmpwocoInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwocoMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
