package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisCopier;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSelect;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiMergeMatlis extends ActionVisitorTemplateMerge<OrderemInfo, MatlisInfo> {
	
	public OrderemVisiMergeMatlis(DeciTreeOption<OrderemInfo> option) {
		super(option, MatlisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return RootMatlisSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toActionClassHook(List<OrderemInfo> baseInfos) {
		return MatlisCopier.copyFromOrderem(baseInfos);	
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return OrderemMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
