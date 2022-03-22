package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhSelect;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusarchMergeSytotauh extends ActionVisitorTemplateMerge<CusarchInfo, SytotauhInfo> {
	
	public VisiCusarchMergeSytotauh(DeciTreeOption<CusarchInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return RootSytotauhSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return CusarchMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
