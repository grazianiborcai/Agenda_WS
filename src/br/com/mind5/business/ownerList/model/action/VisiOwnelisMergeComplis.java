package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.RootComplisSelect;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisMergeComplis extends ActionVisitorTemplateMerge<OwnelisInfo, ComplisInfo> {
	
	public VisiOwnelisMergeComplis(DeciTreeOption<OwnelisInfo> option) {
		super(option, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return RootComplisSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> baseInfos, List<ComplisInfo> selectedInfos) {	
		return OwnelisMerger.mergeWithComplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
