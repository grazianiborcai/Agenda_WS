package br.com.mind5.message.emailUserOtp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.message.emailUserOtp.model.action.EmusotpVisiEnforceEmabody;
import br.com.mind5.message.emailUserOtp.model.action.EmusotpVisiSendEmail;
import br.com.mind5.message.emailUserOtp.model.checker.EmusotpCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmusotpRootSend extends DeciTreeTemplateWrite<EmusotpInfo> {
	
	public EmusotpRootSend(DeciTreeOption<EmusotpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmusotpInfo> buildCheckerHook(DeciTreeOption<EmusotpInfo> option) {		
		List<ModelChecker<EmusotpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmusotpInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmusotpCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmusotpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmusotpInfo> option) {
		List<ActionStd<EmusotpInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmusotpInfo> enforceEmabody = new ActionStdCommom<EmusotpInfo>(option, EmusotpVisiEnforceEmabody.class);
		ActionLazy<EmusotpInfo> send = new ActionLazyCommom<EmusotpInfo>(option, EmusotpVisiSendEmail.class);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
