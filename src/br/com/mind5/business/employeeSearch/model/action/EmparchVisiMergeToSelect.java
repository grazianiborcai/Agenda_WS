package br.com.mind5.business.employeeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmparchVisiMergeToSelect extends ActionVisitorTemplateMerge<EmparchInfo, EmparchInfo> {
	
	public EmparchVisiMergeToSelect(DeciTreeOption<EmparchInfo> option) {
		super(option, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmparchInfo>> getVisitorClassHook() {
		return EmparchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmparchInfo> mergeHook(List<EmparchInfo> baseInfos, List<EmparchInfo> selectedInfos) {	
		return EmparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
