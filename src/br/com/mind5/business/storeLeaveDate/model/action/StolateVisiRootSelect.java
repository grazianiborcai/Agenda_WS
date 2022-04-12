package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.StolateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiRootSelect extends ActionVisitorTemplateAction<StolateInfo, StolateInfo> {

	public StolateVisiRootSelect(DeciTreeOption<StolateInfo> option) {
		super(option, StolateInfo.class, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return StolateRootSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> toBaseClassHook(List<StolateInfo> baseInfos, List<StolateInfo> results) {
		return results;
	}
}
