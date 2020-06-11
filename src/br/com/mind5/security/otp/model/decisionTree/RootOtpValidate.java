package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceHashToMatch;
import br.com.mind5.security.otp.model.action.LazyOtpNodeMatch;
import br.com.mind5.security.otp.model.action.StdOtpEnforceLength;
import br.com.mind5.security.otp.model.checker.OtpCheckValidate;

public final class RootOtpValidate extends DeciTreeTemplateWriteV2<OtpInfo> {
	
	public RootOtpValidate(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtpInfo> buildCheckerHook(DeciTreeOption<OtpInfo> option) {
		List<ModelCheckerV1<OtpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OtpCheckValidate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtpInfo>> buildActionsOnPassedHook(DeciTreeOption<OtpInfo> option) {
		List<ActionStdV1<OtpInfo>> actions = new ArrayList<>();

		ActionStdV1<OtpInfo> enforceLength = new StdOtpEnforceLength(option);
		ActionLazyV1<OtpInfo> enforceHashToMatch = new LazyOtpEnforceHashToMatch(option.conn, option.schemaName);		
		ActionLazyV1<OtpInfo> nodeMatch = new LazyOtpNodeMatch(option.conn, option.schemaName);
			
		enforceLength.addPostAction(enforceHashToMatch);
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(enforceLength);		
		return actions;
	}
}
