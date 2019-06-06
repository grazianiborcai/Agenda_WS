package br.com.gda.business.personList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.model.action.StdPersolisMergeToSelect;
import br.com.gda.business.personList.model.checker.PersolisCheckLangu;
import br.com.gda.business.personList.model.checker.PersolisCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootPersolisSelect extends DeciTreeReadTemplate<PersolisInfo> {
	
	public RootPersolisSelect(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersolisInfo> buildDecisionCheckerHook(DeciTreeOption<PersolisInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<PersolisInfo>> queue = new ArrayList<>();		
		ModelChecker<PersolisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new PersolisCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersolisCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersolisInfo>> buildActionsOnPassedHook(DeciTreeOption<PersolisInfo> option) {
		List<ActionStd<PersolisInfo>> actions = new ArrayList<>();
		
		ActionStd<PersolisInfo> select = new StdPersolisMergeToSelect(option);		
		actions.add(select);
		
		return actions;
	}
}
