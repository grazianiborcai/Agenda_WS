package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhSelect;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpMergeSytotauh extends ActionVisitorTemplateMerge<EmpInfo, SytotauhInfo> {
	
	public VisiEmpMergeSytotauh(DeciTreeOption<EmpInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return RootSytotauhSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return EmpMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
