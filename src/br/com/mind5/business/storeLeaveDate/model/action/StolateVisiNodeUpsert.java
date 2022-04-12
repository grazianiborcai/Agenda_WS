package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.StolateNodeUpsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateVisiNodeUpsert extends ActionVisitorTemplateAction<StolateInfo, StolateInfo> {

	public StolateVisiNodeUpsert(DeciTreeOption<StolateInfo> option) {
		super(option, StolateInfo.class, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return StolateNodeUpsert.class;
	}
	
	
	
	@Override protected List<StolateInfo> toBaseClassHook(List<StolateInfo> baseInfos, List<StolateInfo> results) {
		return results;
	}
}
