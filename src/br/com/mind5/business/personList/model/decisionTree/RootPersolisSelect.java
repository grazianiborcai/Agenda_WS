package br.com.mind5.business.personList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.action.StdPersolisMergeToSelect;
import br.com.mind5.business.personList.model.checker.PersolisCheckLangu;
import br.com.mind5.business.personList.model.checker.PersolisCheckOwner;
import br.com.mind5.business.personList.model.checker.PersolisCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPersolisSelect extends DeciTreeTemplateRead<PersolisInfo> {
	
	public RootPersolisSelect(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersolisInfo> buildCheckerHook(DeciTreeOption<PersolisInfo> option) {
		List<ModelChecker<PersolisInfo>> queue = new ArrayList<>();		
		ModelChecker<PersolisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersolisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersolisCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersolisCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersolisInfo>> buildActionsOnPassedHook(DeciTreeOption<PersolisInfo> option) {
		List<ActionStd<PersolisInfo>> actions = new ArrayList<>();
		
		ActionStd<PersolisInfo> select = new StdPersolisMergeToSelect(option);	
		
		actions.add(select);		
		return actions;
	}
}
