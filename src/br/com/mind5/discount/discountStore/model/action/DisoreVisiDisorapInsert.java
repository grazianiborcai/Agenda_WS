package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreMerger;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.model.decisionTree.DisorapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreVisiDisorapInsert extends ActionVisitorTemplateAction<DisoreInfo, DisorapInfo> {

	public DisoreVisiDisorapInsert(DeciTreeOption<DisoreInfo> option) {
		super(option, DisoreInfo.class, DisorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisorapInfo>> getTreeClassHook() {
		return DisorapRootInsert.class;
	}
	
	
	
	@Override protected List<DisoreInfo> toBaseClassHook(List<DisoreInfo> baseInfos, List<DisorapInfo> results) {
		return DisoreMerger.mergeWithDisorap(baseInfos, results);
	}
}
