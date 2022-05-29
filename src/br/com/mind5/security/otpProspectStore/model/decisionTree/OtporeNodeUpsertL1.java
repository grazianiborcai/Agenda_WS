package br.com.mind5.security.otpProspectStore.model.decisionTree;

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
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiNodeUpsertL2;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiEnforceLChanged;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiEnforceValidUntil;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiOtpGenerate;

public final class OtporeNodeUpsertL1 extends DeciTreeTemplateWrite<OtporeInfo> {
	
	public OtporeNodeUpsertL1(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelChecker<OtporeInfo>> queue = new ArrayList<>();		
		ModelChecker<OtporeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStd<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStd<OtporeInfo> otpGenerate = new ActionStdCommom<OtporeInfo>(option, OtporeVisiOtpGenerate.class);
		ActionLazy<OtporeInfo> enforceLChanged = new ActionLazyCommom<OtporeInfo>(option, OtporeVisiEnforceLChanged.class);
		ActionLazy<OtporeInfo> enforceValidUntil = new ActionLazyCommom<OtporeInfo>(option, OtporeVisiEnforceValidUntil.class);
		ActionLazy<OtporeInfo> nodeL2 = new ActionLazyCommom<OtporeInfo>(option, OtporeVisiNodeUpsertL2.class);
		
		otpGenerate.addPostAction(enforceLChanged);				
		enforceLChanged.addPostAction(enforceValidUntil);
		enforceValidUntil.addPostAction(nodeL2);
		
		actions.add(otpGenerate);	
		return actions;
	}
}
