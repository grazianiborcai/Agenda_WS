package br.com.mind5.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekRootSelect;
import br.com.mind5.business.scheduleWeek.model.action.StdSchedeekMergePrevious;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedeekSelectPrevious extends DeciTreeTemplateWrite<SchedeekInfo> {
	
	public RootSchedeekSelectPrevious(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekInfo> buildCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelChecker<SchedeekInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStd<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekInfo> mergePrevious = new StdSchedeekMergePrevious(option);
		ActionLazy<SchedeekInfo> select = new LazySchedeekRootSelect(option.conn, option.schemaName);
		
		mergePrevious.addPostAction(select);
		
		actions.add(mergePrevious);
		return actions;
	}
}
