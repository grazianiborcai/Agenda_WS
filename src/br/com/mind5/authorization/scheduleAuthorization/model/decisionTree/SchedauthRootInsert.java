package br.com.mind5.authorization.scheduleAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckInsert;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckLangu;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckOwner;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckStore;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckUsername;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedauthRootInsert extends DeciTreeTemplateWrite<SchedauthInfo> {
	
	public SchedauthRootInsert(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedauthInfo> buildCheckerHook(DeciTreeOption<SchedauthInfo> option) {
		List<ModelChecker<SchedauthInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedauthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedauthCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedauthCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedauthCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedauthCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedauthCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedauthInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStd<SchedauthInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedauthInfo> nodeL1 = new SchedauthNodeInsertL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
