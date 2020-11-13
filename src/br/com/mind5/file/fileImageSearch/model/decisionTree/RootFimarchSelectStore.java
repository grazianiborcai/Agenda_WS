package br.com.mind5.file.fileImageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.action.LazyFimarchRootSelect;
import br.com.mind5.file.fileImageSearch.model.action.StdFimarchEnforceStore;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckReadStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFimarchSelectStore extends DeciTreeTemplateReadV2<FimarchInfo> {
	
	public RootFimarchSelectStore(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimarchInfo> buildCheckerHook(DeciTreeOption<FimarchInfo> option) {
		List<ModelCheckerV1<FimarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimarchCheckReadStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FimarchInfo> option) {
		List<ActionStdV1<FimarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FimarchInfo> enforceStore = new StdFimarchEnforceStore(option);
		ActionLazy<FimarchInfo> select = new LazyFimarchRootSelect(option.conn, option.schemaName);
		
		enforceStore.addPostAction(select);
		
		actions.add(enforceStore);
		return actions;
	}
}
