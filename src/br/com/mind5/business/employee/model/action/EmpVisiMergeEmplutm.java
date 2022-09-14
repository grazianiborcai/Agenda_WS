package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmRootSearchEmposFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiMergeEmplutm extends ActionVisitorTemplateMerge<EmpInfo, EmplutmInfo> {
	
	public EmpVisiMergeEmplutm(DeciTreeOption<EmpInfo> option) {
		super(option, EmplutmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmInfo>> getTreeClassHook() {
		return EmplutmRootSearchEmposFallback.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmplutmInfo> selectedInfos) {	
		return EmpMerger.mergeWithEmplutm(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
