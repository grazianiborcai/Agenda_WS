package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposMergePosition;
import br.com.mind5.business.employeePosition.model.action.StdEmposMergeToSelect;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckLangu;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmposSelect extends DeciTreeReadTemplate<EmposInfo> {
	
	public RootEmposSelect(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildDecisionCheckerHook(DeciTreeOption<EmposInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new EmposCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckLangu(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> select	= new StdEmposMergeToSelect(option);
		ActionLazy<EmposInfo> mergePosition = new LazyEmposMergePosition(option.conn, option.schemaName);
		
		select.addPostAction(mergePosition);
		
		actions.add(select);
		return actions;
	}
}
