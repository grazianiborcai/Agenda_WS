package br.com.mind5.security.userPasswordSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.model.action.LazyUpswdarchMergeToSelect;
import br.com.mind5.security.userPasswordSearch.model.action.StdUpswdarchMergeUsername;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckOwner;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckRead;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckUsername;

public final class RootUpswdarchChangedBefore extends DeciTreeTemplateWrite<UpswdarchInfo> {
	
	public RootUpswdarchChangedBefore(DeciTreeOption<UpswdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdarchInfo> buildCheckerHook(DeciTreeOption<UpswdarchInfo> option) {
		List<ModelChecker<UpswdarchInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UpswdarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UpswdarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UpswdarchCheckUsername(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<UpswdarchInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdarchInfo> option) {
		List<ActionStd<UpswdarchInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdarchInfo> mergeUsername = new StdUpswdarchMergeUsername(option);	
		ActionLazy<UpswdarchInfo> select = new LazyUpswdarchMergeToSelect(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(select);
		
		actions.add(mergeUsername);
		
		return actions;
	}
}
