package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUser;
import br.com.mind5.file.fileImage.model.action.LazyFimgNodeUpsertUser;
import br.com.mind5.file.fileImage.model.checker.FimgCheckInsertUser;
import br.com.mind5.file.fileImage.model.checker.FimgCheckUsername;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFimgInsertUserAuth extends DeciTreeWriteTemplate<FimgInfo> {
	
	public RootFimgInsertUserAuth(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> nodeUser = new NodeFimgUser(option).toAction();
		ActionLazyV1<FimgInfo> enforceUser = new LazyFimgEnforceUser(option.conn, option.schemaName);	
		ActionLazyV1<FimgInfo> upsert = new LazyFimgNodeUpsertUser(option.conn, option.schemaName);
		
		nodeUser.addPostAction(enforceUser);
		enforceUser.addPostAction(upsert);
		
		actions.add(nodeUser);		
		return actions;
	}
}
