package br.com.mind5.message.emailUserOtp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.message.emailUserOtp.model.action.LazyEmusotpSendEmail;
import br.com.mind5.message.emailUserOtp.model.action.StdEmusotpEnforceEmabody;
import br.com.mind5.message.emailUserOtp.model.checker.EmusotpCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmusotpSend extends DeciTreeTemplateWriteV2<EmusotpInfo> {
	
	public RootEmusotpSend(DeciTreeOption<EmusotpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmusotpInfo> buildCheckerHook(DeciTreeOption<EmusotpInfo> option) {		
		List<ModelCheckerV1<EmusotpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmusotpInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmusotpCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmusotpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmusotpInfo> option) {
		List<ActionStdV2<EmusotpInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<EmusotpInfo> enforceEmabody = new StdEmusotpEnforceEmabody(option);
		ActionLazy<EmusotpInfo> send = new LazyEmusotpSendEmail(option.conn, option.schemaName);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
