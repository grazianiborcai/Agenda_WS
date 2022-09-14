package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiEnforceIsDeletedOn;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiEnforceEmposKey;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeStolis;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeWeekdayFallback;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiNodeSearchStoreFallback;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckSearch;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplutmRootSearchEmposFallback extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmRootSearchEmposFallback(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmplutmCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> enforceEmposKey = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiEnforceEmposKey.class);
		ActionLazy<EmplutmInfo> mergeStolis = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiMergeStolis.class);
		ActionLazy<EmplutmInfo> enforceIsDeletedOn = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiEnforceIsDeletedOn.class);
		ActionLazy<EmplutmInfo> mergeWeekday = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiMergeWeekdayFallback.class);
		ActionLazy<EmplutmInfo> nodeL1 = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiNodeSearchStoreFallback.class);
		
		enforceEmposKey.addPostAction(mergeStolis);
		mergeStolis.addPostAction(enforceIsDeletedOn);
		enforceIsDeletedOn.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(nodeL1);
		
		actions.add(enforceEmposKey);		
		return actions; 
	}
}
