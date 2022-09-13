package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.StowotmNodeSearchStoreFallback;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmVisiNodeSearchStoreFallback extends ActionVisitorTemplateAction<StowotmInfo, StowotmInfo> {

	public StowotmVisiNodeSearchStoreFallback(DeciTreeOption<StowotmInfo> option) {
		super(option, StowotmInfo.class, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return StowotmNodeSearchStoreFallback.class;
	}
	
	
	
	@Override protected List<StowotmInfo> toBaseClassHook(List<StowotmInfo> baseInfos, List<StowotmInfo> results) {
		return results;
	}
}
