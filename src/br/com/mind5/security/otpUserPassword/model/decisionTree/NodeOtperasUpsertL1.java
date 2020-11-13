package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasEnforceLChanged;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasEnforceValidUntil;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasMergeUsername;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasNodeUpsertL2;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasOtpGenerate;

public final class NodeOtperasUpsertL1 extends DeciTreeTemplateWrite<OtperasInfo> {
	
	public NodeOtperasUpsertL1(DeciTreeOption<OtperasInfo> option) {
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
		
		ActionStd<OtperasInfo> otpGenerate = new StdOtperasOtpGenerate(option);
		ActionLazy<OtperasInfo> enforceLChanged = new LazyOtperasEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OtperasInfo> enforceValidUntil = new LazyOtperasEnforceValidUntil(option.conn, option.schemaName);
		ActionLazy<OtperasInfo> mergeUsername = new LazyOtperasMergeUsername(option.conn, option.schemaName);
		ActionLazy<OtperasInfo> nodeL2 = new LazyOtperasNodeUpsertL2(option.conn, option.schemaName);
		
		otpGenerate.addPostAction(enforceLChanged);				
		enforceLChanged.addPostAction(enforceValidUntil);
		enforceValidUntil.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(otpGenerate);	
		return actions;
	}
}
