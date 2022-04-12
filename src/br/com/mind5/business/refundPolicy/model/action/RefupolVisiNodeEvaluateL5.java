package br.com.mind5.business.refundPolicy.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.decisionTree.RefupolNodeEvaluateL5;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupolVisiNodeEvaluateL5 extends ActionVisitorTemplateAction<RefupolInfo, RefupolInfo> {

	public RefupolVisiNodeEvaluateL5(DeciTreeOption<RefupolInfo> option) {
		super(option, RefupolInfo.class, RefupolInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupolInfo>> getTreeClassHook() {
		return RefupolNodeEvaluateL5.class;
	}
	
	
	
	@Override protected List<RefupolInfo> toBaseClassHook(List<RefupolInfo> baseInfos, List<RefupolInfo> results) {
		return results;
	}
}
