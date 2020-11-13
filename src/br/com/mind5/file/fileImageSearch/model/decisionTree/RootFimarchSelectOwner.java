package br.com.mind5.file.fileImageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.action.LazyFimarchRootSelect;
import br.com.mind5.file.fileImageSearch.model.action.StdFimarchEnforceOwner;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckReadOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFimarchSelectOwner extends DeciTreeTemplateRead<FimarchInfo> {
	
	public RootFimarchSelectOwner(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimarchInfo> buildCheckerHook(DeciTreeOption<FimarchInfo> option) {
		List<ModelChecker<FimarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FimarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimarchCheckReadOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FimarchInfo> option) {
		List<ActionStd<FimarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FimarchInfo> enforceOwner = new StdFimarchEnforceOwner(option);
		ActionLazy<FimarchInfo> select = new LazyFimarchRootSelect(option.conn, option.schemaName);
		
		enforceOwner.addPostAction(select);
		
		actions.add(enforceOwner);
		return actions;
	}
}
