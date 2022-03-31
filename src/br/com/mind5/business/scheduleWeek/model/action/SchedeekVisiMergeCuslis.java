package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisCopier;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.CuslisRootSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekVisiMergeCuslis extends ActionVisitorTemplateMerge<SchedeekInfo, CuslisInfo> {
	
	public SchedeekVisiMergeCuslis(DeciTreeOption<SchedeekInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return CuslisRootSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return CuslisCopier.copyFromSchedeek(baseInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
