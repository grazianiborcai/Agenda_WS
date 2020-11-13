package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEmacomeSend;
import br.com.mind5.security.userPassword.model.action.LazyUpswdSuccess;

public final class RootUpswdInsert extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public RootUpswdInsert(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> insertUpswd = new RootUpswdInsertSilent(option).toAction();
		ActionLazy<UpswdInfo> sendEmail = new LazyUpswdEmacomeSend(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> success = new LazyUpswdSuccess(option.conn, option.schemaName);
		
		insertUpswd.addPostAction(sendEmail);
		sendEmail.addPostAction(success);
		
		actions.add(insertUpswd);	
		return actions;
	}
}
