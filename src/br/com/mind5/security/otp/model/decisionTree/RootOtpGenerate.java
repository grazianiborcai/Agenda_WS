package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceHash;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceLength;
import br.com.mind5.security.otp.model.action.LazyOtpEnforceSalt;
import br.com.mind5.security.otp.model.action.StdOtpEnforceRandom;

public final class RootOtpGenerate extends DeciTreeTemplateWriteV2<OtpInfo> {
	
	public RootOtpGenerate(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtpInfo> buildCheckerHook(DeciTreeOption<OtpInfo> option) {
		List<ModelCheckerV1<OtpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtpInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OtpInfo>> buildActionsOnPassedHook(DeciTreeOption<OtpInfo> option) {
		List<ActionStdV2<OtpInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OtpInfo> enforceRandom = new StdOtpEnforceRandom(option);
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
