package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.OtpVisiEnforceHash;
import br.com.mind5.security.otp.model.action.OtpVisiEnforceLength;
import br.com.mind5.security.otp.model.action.OtpVisiEnforceRandom;
import br.com.mind5.security.otp.model.action.OtpVisiEnforceSalt;

public final class OtpRootGenerate extends DeciTreeTemplateWrite<OtpInfo> {
	
	public OtpRootGenerate(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtpInfo> buildCheckerHook(DeciTreeOption<OtpInfo> option) {
		List<ModelChecker<OtpInfo>> queue = new ArrayList<>();		
		ModelChecker<OtpInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtpInfo>> buildActionsOnPassedHook(DeciTreeOption<OtpInfo> option) {
		List<ActionStd<OtpInfo>> actions = new ArrayList<>();
		
		ActionStd<OtpInfo> enforceRandom = new ActionStdCommom<OtpInfo>(option, OtpVisiEnforceRandom.class);
		ActionLazy<OtpInfo> enforceLength = new ActionLazyCommom<OtpInfo>(option, OtpVisiEnforceLength.class);
		ActionLazy<OtpInfo> enforceSalt = new ActionLazyCommom<OtpInfo>(option, OtpVisiEnforceSalt.class);
		ActionLazy<OtpInfo> enforceHash = new ActionLazyCommom<OtpInfo>(option, OtpVisiEnforceHash.class);
		
		enforceRandom.addPostAction(enforceLength);
		enforceLength.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);
		
		actions.add(enforceRandom);	
		return actions;
	}
}
