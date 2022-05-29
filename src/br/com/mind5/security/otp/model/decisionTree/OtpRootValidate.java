package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.OtpVisiNodeMatch;
import br.com.mind5.security.otp.model.action.OtpVisiEnforceHashToMatch;
import br.com.mind5.security.otp.model.action.OtpVisiEnforceLength;
import br.com.mind5.security.otp.model.checker.OtpCheckExpiry;
import br.com.mind5.security.otp.model.checker.OtpCheckValidate;

public final class OtpRootValidate extends DeciTreeTemplateWrite<OtpInfo> {
	
	public OtpRootValidate(DeciTreeOption<OtpInfo> option) {
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

		ActionStd<OtpInfo> enforceLength = new ActionStdCommom<OtpInfo>(option, OtpVisiEnforceLength.class);
		ActionLazy<OtpInfo> enforceHashToMatch = new ActionLazyCommom<OtpInfo>(option, OtpVisiEnforceHashToMatch.class);		
		ActionLazy<OtpInfo> nodeMatch = new ActionLazyCommom<OtpInfo>(option, OtpVisiNodeMatch.class);
			
		enforceLength.addPostAction(enforceHashToMatch);
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(enforceLength);		
		return actions;
	}
}
