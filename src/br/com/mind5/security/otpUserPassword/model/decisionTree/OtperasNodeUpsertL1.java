package br.com.mind5.security.otpUserPassword.model.decisionTree;

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
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiNodeUpsertL2;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiEnforceLChanged;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiEnforceValidUntil;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiMergeUsername;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiOtpGenerate;

public final class OtperasNodeUpsertL1 extends DeciTreeTemplateWrite<OtperasInfo> {
	
	public OtperasNodeUpsertL1(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtperasInfo> buildCheckerHook(DeciTreeOption<OtperasInfo> option) {
		List<ModelChecker<OtperasInfo>> queue = new ArrayList<>();		
		ModelChecker<OtperasInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStd<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStd<OtperasInfo> otpGenerate = new ActionStdCommom<OtperasInfo>(option, OtperasVisiOtpGenerate.class);
		ActionLazy<OtperasInfo> enforceLChanged = new ActionLazyCommom<OtperasInfo>(option, OtperasVisiEnforceLChanged.class);
		ActionLazy<OtperasInfo> enforceValidUntil = new ActionLazyCommom<OtperasInfo>(option, OtperasVisiEnforceValidUntil.class);
		ActionLazy<OtperasInfo> mergeUsername = new ActionLazyCommom<OtperasInfo>(option, OtperasVisiMergeUsername.class);
		ActionLazy<OtperasInfo> nodeL2 = new ActionLazyCommom<OtperasInfo>(option, OtperasVisiNodeUpsertL2.class);
		
		otpGenerate.addPostAction(enforceLChanged);				
		enforceLChanged.addPostAction(enforceValidUntil);
		enforceValidUntil.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(otpGenerate);	
		return actions;
	}
}
