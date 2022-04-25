package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoUpdate;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiEmplutmapInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplutmNodeSnapshot extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmNodeSnapshot(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> insertEmplutmap = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiEmplutmapInsert.class);		
		ActionLazy<EmplutmInfo> update = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiDaoUpdate.class);	
		
		insertEmplutmap.addPostAction(update);
		
		actions.add(insertEmplutmap);	
		return actions;
	}
}
