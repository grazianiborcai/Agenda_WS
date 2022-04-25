package br.com.mind5.business.employeeLunchTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpulranVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpulranInfo, EmpulranInfo> {
	
	public EmpulranVisiMergeToSelect(DeciTreeOption<EmpulranInfo> option) {
		super(option, EmpulranInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpulranInfo>> getVisitorClassHook() {
		return EmpulranVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpulranInfo> mergeHook(List<EmpulranInfo> baseInfos, List<EmpulranInfo> selectedInfos) {	
		return EmpulranMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
