package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreSelect;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeMatore extends ActionVisitorTemplateMergeV2<OrderemInfo, MatoreInfo> {
	
	public VisiOrderemMergeMatore(DeciTreeOption<OrderemInfo> option) {
		super(option, MatoreInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return RootMatoreSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<MatoreInfo> selectedInfos) {	
		return OrderemMerger.mergeWithMatore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
