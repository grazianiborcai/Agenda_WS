package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEmordeSend;
import br.com.mind5.security.userPassword.model.action.UpswdVisiJwtokenGenerate;
import br.com.mind5.security.userPassword.model.action.UpswdVisiMergeUsername;
import br.com.mind5.security.userPassword.model.action.UpswdVisiNodeUpdateL2;
import br.com.mind5.security.userPassword.model.action.UpswdVisiObfuscate;
import br.com.mind5.security.userPassword.model.action.UpswdVisiOtperasAuthenticate;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckUsername;

public final class UpswdNodeUpdateL1 extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public UpswdNodeUpdateL1(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UpswdCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd <UpswdInfo> mergeUsername       = new ActionStdCommom<UpswdInfo>(option, UpswdVisiMergeUsername.class);
		ActionLazy<UpswdInfo> otperasAuthenticate = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiOtperasAuthenticate.class);
		ActionLazy<UpswdInfo> nodeL2              = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiNodeUpdateL2.class);
		ActionLazy<UpswdInfo> sendEmail           = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEmordeSend.class);
		ActionLazy<UpswdInfo> obfuscate           = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiObfuscate.class);
		ActionLazy<UpswdInfo> jwtokenGenerate     = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiJwtokenGenerate.class);
		
		mergeUsername.addPostAction(otperasAuthenticate);
		otperasAuthenticate.addPostAction(nodeL2);
		nodeL2.addPostAction(sendEmail);
		sendEmail.addPostAction(obfuscate);
		obfuscate.addPostAction(jwtokenGenerate);
		
		actions.add(mergeUsername);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnFailedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> success = new ActionStdSuccessCommom<UpswdInfo>(option);

		actions.add(success);	
		return actions;
	}
}
