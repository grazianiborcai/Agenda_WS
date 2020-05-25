package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisCopier;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.info.SchedayMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedayMergeCuslis extends ActionVisitorTemplateMergeV2<SchedayInfo, CuslisInfo> {
	
	public VisiSchedayMergeCuslis(DeciTreeOption<SchedayInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> toActionClassHook(List<SchedayInfo> recordInfos) {
		return CuslisCopier.copyFromScheday(recordInfos);
	}
	
	
	
	@Override protected List<SchedayInfo> mergeHook(List<SchedayInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return SchedayMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
