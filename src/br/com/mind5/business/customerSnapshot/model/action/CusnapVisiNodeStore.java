package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.decisionTree.CusnapNodeStore;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusnapVisiNodeStore extends ActionVisitorTemplateAction<CusnapInfo, CusnapInfo> {

	public CusnapVisiNodeStore(DeciTreeOption<CusnapInfo> option) {
		super(option, CusnapInfo.class, CusnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusnapInfo>> getTreeClassHook() {
		return CusnapNodeStore.class;
	}
	
	
	
	@Override protected List<CusnapInfo> toBaseClassHook(List<CusnapInfo> baseInfos, List<CusnapInfo> results) {
		return results;
	}
}
