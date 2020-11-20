package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUser;
import br.com.mind5.file.fileImage.model.action.LazyFimgNodeInsertUserAuth;
import br.com.mind5.file.fileImage.model.action.LazyFimgNodeUpsertUser;
import br.com.mind5.file.fileImage.model.checker.FimgCheckInsertUser;
import br.com.mind5.file.fileImage.model.checker.FimgCheckUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFimgInsertUserAuth extends DeciTreeTemplateWrite<FimgInfo> {
	
	public RootFimgInsertUserAuth(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckInsertUser(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> nodeUser = new NodeFimgUser(option).toAction();
		ActionLazy<FimgInfo> enforceUser = new LazyFimgEnforceUser(option.conn, option.schemaName);
		ActionLazy<FimgInfo> upsert = new LazyFimgNodeUpsertUser(option.conn, option.schemaName);	
		ActionLazy<FimgInfo> nodeL1 = new LazyFimgNodeInsertUserAuth(option.conn, option.schemaName);
			
		
		nodeUser.addPostAction(enforceUser);
		enforceUser.addPostAction(upsert);
		upsert.addPostAction(nodeL1);
		
		actions.add(nodeUser);		
		return actions;
	}
}
