package br.com.mind5.business.employeeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.action.LazyEmplisMergeFimist;
import br.com.mind5.business.employeeList.model.action.LazyEmplisMergePersolis;
import br.com.mind5.business.employeeList.model.action.StdEmplisMergeToSelect;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckLangu;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckOwner;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmplisSelect extends DeciTreeTemplateRead<EmplisInfo> {
	
	public RootEmplisSelect(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplisInfo> buildCheckerHook(DeciTreeOption<EmplisInfo> option) {
		List<ModelCheckerV1<EmplisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplisCheckRead(checkerOption);
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmplisInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStdV1<EmplisInfo>> actions = new ArrayList<>();

		ActionStdV1<EmplisInfo> select = new StdEmplisMergeToSelect(option);
		ActionLazyV1<EmplisInfo> mergePersolis = new LazyEmplisMergePersolis(option.conn, option.schemaName);
		ActionLazyV1<EmplisInfo> mergeFimist = new LazyEmplisMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergePersolis);
		mergePersolis.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
