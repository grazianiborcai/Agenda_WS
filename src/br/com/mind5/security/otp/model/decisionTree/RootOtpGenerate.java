package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceHash;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceLength;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceSalt;
import br.com.mind5.security.otp.model.action.StdOtpEnforceRandom;

public final class RootOtpGenerate extends DeciTreeTemplateWrite<OtpInfo> {
	
	public RootOtpGenerate(DeciTreeOption<OtpInfo> option) {
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
		
		ActionStd<OtpInfo> enforceRandom = new StdOtpEnforceRandom(option);
		ActionLazy<OtpInfo> enforceLength = new LazyOtpEnforceLength(option.conn, option.schemaName);
		ActionLazy<OtpInfo> enforceSalt = new LazyOtpEnforceSalt(option.conn, option.schemaName);
		ActionLazy<OtpInfo> enforceHash = new LazyOtpEnforceHash(option.conn, option.schemaName);
		
		enforceRandom.addPostAction(enforceLength);
		enforceLength.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);
		
		actions.add(enforceRandom);	
		return actions;
	}
}
