package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.LazyCuslisMergeFimist;
import br.com.mind5.business.customerList.model.action.LazyCuslisMergePersolis;
import br.com.mind5.business.customerList.model.action.StdCuslisMergeToSelect;
import br.com.mind5.business.customerList.model.checker.CuslisCheckLangu;
import br.com.mind5.business.customerList.model.checker.CuslisCheckOwner;
import br.com.mind5.business.customerList.model.checker.CuslisCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCuslisSelect extends DeciTreeTemplateReadV2<CuslisInfo> {
	
	public RootCuslisSelect(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CuslisInfo> buildCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelCheckerV1<CuslisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CuslisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CuslisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CuslisCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CuslisCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStdV1<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CuslisInfo> select = new StdCuslisMergeToSelect(option);
		ActionLazyV1<CuslisInfo> mergePersolis = new LazyCuslisMergePersolis(option.conn, option.schemaName);
		ActionLazyV1<CuslisInfo> mergeFimist = new LazyCuslisMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergePersolis);
		mergePersolis.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
