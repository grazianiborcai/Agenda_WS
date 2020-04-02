package br.com.mind5.business.employeeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.action.LazyEmplisMergeEmparch;
import br.com.mind5.business.employeeList.model.action.LazyEmplisRootSelect;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckLangu;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckOwner;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckSearch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmplisSearch extends DeciTreeReadTemplate<EmplisInfo> {
	
	public RootEmplisSearch(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplisInfo> buildDecisionCheckerHook(DeciTreeOption<EmplisInfo> option) {
		List<ModelChecker<EmplisInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplisCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplisCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplisCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmplisInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStdV1<EmplisInfo>> actions = new ArrayList<>();

		ActionStdV1<EmplisInfo> nodePerson = new NodeEmplisPerson(option).toAction();
		ActionLazyV1<EmplisInfo> mergeEmparch = new LazyEmplisMergeEmparch(option.conn, option.schemaName);
		ActionLazyV1<EmplisInfo> select = new LazyEmplisRootSelect(option.conn, option.schemaName);
		
		nodePerson.addPostAction(mergeEmparch);
		mergeEmparch.addPostAction(select);
		
		actions.add(nodePerson);
		return actions;
	}
}
