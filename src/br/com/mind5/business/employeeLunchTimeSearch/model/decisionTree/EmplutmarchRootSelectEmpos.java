package br.com.mind5.business.employeeLunchTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.action.EmplutmarchVisiEnforceEmposKey;
import br.com.mind5.business.employeeLunchTimeSearch.model.action.EmplutmarchVisiRootSelect;
import br.com.mind5.business.employeeLunchTimeSearch.model.checker.EmplutmarchCheckReadEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmplutmarchRootSelectEmpos extends DeciTreeTemplateRead<EmplutmarchInfo> {
	
	public EmplutmarchRootSelectEmpos(DeciTreeOption<EmplutmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmarchInfo> buildCheckerHook(DeciTreeOption<EmplutmarchInfo> option) {
		List<ModelChecker<EmplutmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmarchCheckReadEmpos(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmarchInfo> option) {
		List<ActionStd<EmplutmarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmarchInfo> enforceEmposKey = new ActionStdCommom<EmplutmarchInfo>(option, EmplutmarchVisiEnforceEmposKey.class);
		ActionLazy<EmplutmarchInfo> select = new ActionLazyCommom<EmplutmarchInfo>(option, EmplutmarchVisiRootSelect.class);
		
		enforceEmposKey.addPostAction(select);
		
		actions.add(enforceEmposKey);		
		return actions; 
	}
}
