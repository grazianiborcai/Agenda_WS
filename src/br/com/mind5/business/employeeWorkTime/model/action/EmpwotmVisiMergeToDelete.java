package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmVisiMergeToDelete extends ActionVisitorTemplateMerge<EmpwotmInfo, EmpwotmInfo> {
	
	public EmpwotmVisiMergeToDelete(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpwotmInfo>> getVisitorClassHook() {
		return EmpwotmVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {	
		return EmpwotmMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
