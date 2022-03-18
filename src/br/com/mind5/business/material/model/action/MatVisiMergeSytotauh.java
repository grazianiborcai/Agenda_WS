package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhSelect;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMergeSytotauh extends ActionVisitorTemplateMerge<MatInfo, SytotauhInfo> {
	
	public MatVisiMergeSytotauh(DeciTreeOption<MatInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return RootSytotauhSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return MatMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
