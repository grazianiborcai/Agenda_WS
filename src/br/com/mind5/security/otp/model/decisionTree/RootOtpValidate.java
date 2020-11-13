package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceHashToMatch;
import br.com.mind5.security.otp.model.action.LazyOtpNodeMatch;
import br.com.mind5.security.otp.model.action.StdOtpEnforceLength;
import br.com.mind5.security.otp.model.checker.OtpCheckExpiry;
import br.com.mind5.security.otp.model.checker.OtpCheckValidate;

public final class RootOtpValidate extends DeciTreeTemplateWrite<OtpInfo> {
	
	public RootOtpValidate(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtpInfo> buildCheckerHook(DeciTreeOption<OtpInfo> option) {
		List<ModelChecker<OtpInfo>> queue = new ArrayList<>();		
		ModelChecker<OtpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OtpCheckValidate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OtpCheckExpiry(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtpInfo>> buildActionsOnPassedHook(DeciTreeOption<OtpInfo> option) {
		List<ActionStd<OtpInfo>> actions = new ArrayList<>();

		ActionStd<OtpInfo> enforceLength = new StdOtpEnforceLength(option);
		ActionLazy<OtpInfo> enforceHashToMatch = new LazyOtpEnforceHashToMatch(option.conn, option.schemaName);		
		ActionLazy<OtpInfo> nodeMatch = new LazyOtpNodeMatch(option.conn, option.schemaName);
			
		enforceLength.addPostAction(enforceHashToMatch);
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(enforceLength);		
		return actions;
	}
}
