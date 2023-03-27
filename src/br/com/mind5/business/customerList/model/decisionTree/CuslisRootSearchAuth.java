package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.CuslisVisiMergeCusarchAuth;
import br.com.mind5.business.customerList.model.action.CuslisVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CuslisRootSearchAuth extends DeciTreeTemplateRead<CuslisInfo> {
	
	public CuslisRootSearchAuth(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CuslisInfo> buildCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelChecker<CuslisInfo>> queue = new ArrayList<>();		
		ModelChecker<CuslisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStd<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStd <CuslisInfo> mergeCusarch = new ActionStdCommom <CuslisInfo>(option, CuslisVisiMergeCusarchAuth.class);
		ActionLazy<CuslisInfo> select       = new ActionLazyCommom<CuslisInfo>(option, CuslisVisiRootSelect.class);
		
		mergeCusarch.addPostAction(select);
		
		actions.add(mergeCusarch);
		return actions;
	}
}
