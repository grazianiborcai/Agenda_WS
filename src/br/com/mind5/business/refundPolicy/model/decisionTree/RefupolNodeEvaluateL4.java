package br.com.mind5.business.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.action.RefupolVisiNodeEvaluateL5;
import br.com.mind5.business.refundPolicy.model.action.RefupolVisiEnforceHasPassed;
import br.com.mind5.business.refundPolicy.model.action.RefupolVisiEnforceRHour;
import br.com.mind5.business.refundPolicy.model.action.RefupolVisiMergeRefupore;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckEvaluateService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RefupolNodeEvaluateL4 extends DeciTreeTemplateWrite<RefupolInfo> {
	
	public RefupolNodeEvaluateL4(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefupolInfo> buildCheckerHook(DeciTreeOption<RefupolInfo> option) {
		List<ModelChecker<RefupolInfo>> queue = new ArrayList<>();		
		ModelChecker<RefupolInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new RefupolCheckEvaluateService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStd<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStd<RefupolInfo> mergeRefupore = new ActionStdCommom<RefupolInfo>(option, RefupolVisiMergeRefupore.class);
		ActionLazy<RefupolInfo> enforceRHour = new ActionLazyCommom<RefupolInfo>(option, RefupolVisiEnforceRHour.class);
		ActionLazy<RefupolInfo> enfoerceHasPassed = new ActionLazyCommom<RefupolInfo>(option, RefupolVisiEnforceHasPassed.class);
		ActionLazy<RefupolInfo> nodeL5 = new ActionLazyCommom<RefupolInfo>(option, RefupolVisiNodeEvaluateL5.class);
		
		mergeRefupore.addPostAction(enforceRHour);
		enforceRHour.addPostAction(enfoerceHasPassed);
		enfoerceHasPassed.addPostAction(nodeL5);
		
		actions.add(mergeRefupore);
		return actions;
	}
}
