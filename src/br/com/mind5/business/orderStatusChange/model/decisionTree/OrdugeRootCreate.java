package br.com.mind5.business.orderStatusChange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.action.OrdugeVisiEnforceCreated;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdugeRootCreate extends DeciTreeTemplateRead<OrdugeInfo> {
	
	public OrdugeRootCreate(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdugeInfo> buildCheckerHook(DeciTreeOption<OrdugeInfo> option) {
		List<ModelChecker<OrdugeInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdugeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdugeInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdugeInfo> option) {
		List<ActionStd<OrdugeInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdugeInfo> enforceStatus = new ActionStdCommom<OrdugeInfo>(option, OrdugeVisiEnforceCreated.class);
		
		actions.add(enforceStatus);			
		return actions;
	}
}
