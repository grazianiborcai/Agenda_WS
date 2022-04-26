package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmMerger;
import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.decisionTree.EmplutmarchRootSelectEmpos;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiMergeEmplutmarchEmpos extends ActionVisitorTemplateMerge<EmplutmInfo, EmplutmarchInfo> {
	
	public EmplutmVisiMergeEmplutmarchEmpos(DeciTreeOption<EmplutmInfo> option) {
		super(option, EmplutmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmarchInfo>> getTreeClassHook() {
		return EmplutmarchRootSelectEmpos.class;
	}
	
	
	
	@Override protected List<EmplutmInfo> mergeHook(List<EmplutmInfo> baseInfos, List<EmplutmarchInfo> selectedInfos) {	
		return EmplutmMerger.mergeWithEmplutmarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
