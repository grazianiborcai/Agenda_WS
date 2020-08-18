package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmatMergeToDelete extends ActionVisitorTemplateMergeV2<EmpmatInfo, EmpmatInfo> {
	
	public VisiEmpmatMergeToDelete(DeciTreeOption<EmpmatInfo> option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmpmatInfo>> getActionClassHook() {
		return StdEmpmatDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> baseInfos, List<EmpmatInfo> selectedInfos) {	
		return EmpmatMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
