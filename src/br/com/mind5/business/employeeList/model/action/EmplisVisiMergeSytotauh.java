package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.SytotauhRootSelect;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisVisiMergeSytotauh extends ActionVisitorTemplateMerge<EmplisInfo, SytotauhInfo> {
	
	public EmplisVisiMergeSytotauh(DeciTreeOption<EmplisInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return SytotauhRootSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return EmplisMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
