package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpmatInfo, EmpmatInfo> {
	
	public EmpmatVisiMergeToSelect(DeciTreeOption<EmpmatInfo> option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpmatInfo>> getVisitorClassHook() {
		return EmpmatVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> baseInfos, List<EmpmatInfo> selectedInfos) {	
		return EmpmatMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
