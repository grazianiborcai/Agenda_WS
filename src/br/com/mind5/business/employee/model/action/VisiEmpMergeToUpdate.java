package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpMergeToUpdate extends ActionVisitorTemplateMergeV2<EmpInfo, EmpInfo> {
	
	public VisiEmpMergeToUpdate(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmpInfo>> getActionClassHook() {
		return StdEmpDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {	
		return EmpMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
