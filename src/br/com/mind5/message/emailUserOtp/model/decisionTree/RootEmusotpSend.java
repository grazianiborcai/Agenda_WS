package br.com.mind5.message.emailUserOtp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.message.emailUserOtp.model.action.LazyEmusotpSendEmail;
import br.com.mind5.message.emailUserOtp.model.action.StdEmusotpEnforceEmabody;
import br.com.mind5.message.emailUserOtp.model.checker.EmusotpCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmusotpSend extends DeciTreeTemplateWrite<EmusotpInfo> {
	
	public RootEmusotpSend(DeciTreeOption<EmusotpInfo> option) {
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
		
		ActionStd<EmusotpInfo> enforceEmabody = new StdEmusotpEnforceEmabody(option);
		ActionLazy<EmusotpInfo> send = new LazyEmusotpSendEmail(option.conn, option.schemaName);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
