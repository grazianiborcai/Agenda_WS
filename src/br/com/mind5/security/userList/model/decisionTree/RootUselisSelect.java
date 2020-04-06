package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.LazyUselisMergePersolis;
import br.com.mind5.security.userList.model.action.StdUselisMergeToSelect;
import br.com.mind5.security.userList.model.checker.UselisCheckLangu;
import br.com.mind5.security.userList.model.checker.UselisCheckOwner;
import br.com.mind5.security.userList.model.checker.UselisCheckRead;

public final class RootUselisSelect extends DeciTreeTemplateRead<UselisInfo> {
	
	public RootUselisSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UselisInfo> buildCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelCheckerV1<UselisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UselisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UselisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UselisCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UselisCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStdV1<UselisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UselisInfo> select = new StdUselisMergeToSelect(option);
		ActionLazyV1<UselisInfo> mergePerson = new LazyUselisMergePersolis(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		
		actions.add(select);
		return actions;
	}
}
