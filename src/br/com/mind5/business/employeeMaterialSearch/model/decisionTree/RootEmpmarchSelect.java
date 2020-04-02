package br.com.mind5.business.employeeMaterialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.action.StdEmpmarchMergeToSelect;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckLangu;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckOwner;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpmarchSelect extends DeciTreeReadTemplate<EmpmarchInfo> {
	
	public RootEmpmarchSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmarchInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ModelChecker<EmpmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ActionStdV1<EmpmarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpmarchInfo> select = new StdEmpmarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
