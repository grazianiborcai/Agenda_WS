package br.com.mind5.security.userPasswordSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.model.action.LazyUpswdarchMergeToSelect;
import br.com.mind5.security.userPasswordSearch.model.action.StdUpswdarchMergeUsername;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckOwner;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckRead;
import br.com.mind5.security.userPasswordSearch.model.checker.UpswdarchCheckUsername;

public final class RootUpswdarchChangedBefore extends DeciTreeTemplateWriteV2<UpswdarchInfo> {
	
	public RootUpswdarchChangedBefore(DeciTreeOption<UpswdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UpswdarchInfo> buildCheckerHook(DeciTreeOption<UpswdarchInfo> option) {
		List<ModelCheckerV1<UpswdarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UpswdarchInfo> checker;
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
		
		 return new ModelCheckerHelperQueueV2<UpswdarchInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdarchInfo> option) {
		List<ActionStdV1<UpswdarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdarchInfo> mergeUsername = new StdUpswdarchMergeUsername(option);	
		ActionLazy<UpswdarchInfo> select = new LazyUpswdarchMergeToSelect(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(select);
		
		actions.add(mergeUsername);
		
		return actions;
	}
}
