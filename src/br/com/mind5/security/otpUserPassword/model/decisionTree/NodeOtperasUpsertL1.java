package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasEnforceLChanged;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasEnforceValidUntil;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasMergeUsername;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasNodeUpsertL2;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasOtpGenerate;

public final class NodeOtperasUpsertL1 extends DeciTreeTemplateWriteV2<OtperasInfo> {
	
	public NodeOtperasUpsertL1(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtperasInfo> buildCheckerHook(DeciTreeOption<OtperasInfo> option) {
		List<ModelCheckerV1<OtperasInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtperasInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStdV2<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OtperasInfo> otpGenerate = new StdOtperasOtpGenerate(option);
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
