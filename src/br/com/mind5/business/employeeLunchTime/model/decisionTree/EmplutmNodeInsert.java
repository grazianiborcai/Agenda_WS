package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoInsert;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoUpdate;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiNodeSnapshot;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplutmNodeInsert extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmNodeInsert(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;
		
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;
		checker = new EmplutmCheckSoftDelete(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> insert = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiDaoInsert.class);
		ActionLazy<EmplutmInfo> snapshot = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiNodeSnapshot.class);
		
		insert.addPostAction(snapshot);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> update = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiDaoUpdate.class);
		ActionLazy<EmplutmInfo> snapshot = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiNodeSnapshot.class);
		
		update.addPostAction(snapshot);
		
		actions.add(update);
		return actions;
	}
}
