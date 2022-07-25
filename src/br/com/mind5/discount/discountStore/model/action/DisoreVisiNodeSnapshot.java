package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.decisionTree.DisoreNodeSnapshot;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreVisiNodeSnapshot extends ActionVisitorTemplateAction<DisoreInfo, DisoreInfo> {

	public DisoreVisiNodeSnapshot(DeciTreeOption<DisoreInfo> option) {
		super(option, DisoreInfo.class, DisoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisoreInfo>> getTreeClassHook() {
		return DisoreNodeSnapshot.class;
	}
	
	
	
	@Override protected List<DisoreInfo> toBaseClassHook(List<DisoreInfo> baseInfos, List<DisoreInfo> results) {
		return results;
	}
}
