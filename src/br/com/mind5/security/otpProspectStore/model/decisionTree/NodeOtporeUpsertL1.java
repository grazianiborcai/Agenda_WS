package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeEnforceLChanged;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeEnforceValidUntil;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeNodeUpsertL2;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeOtpGenerate;

public final class NodeOtporeUpsertL1 extends DeciTreeTemplateWrite<OtporeInfo> {
	
	public NodeOtporeUpsertL1(DeciTreeOption<OtporeInfo> option) {
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
		
		ActionStd<OtporeInfo> otpGenerate = new StdOtporeOtpGenerate(option);
		ActionLazy<OtporeInfo> enforceLChanged = new LazyOtporeEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OtporeInfo> enforceValidUntil = new LazyOtporeEnforceValidUntil(option.conn, option.schemaName);
		ActionLazy<OtporeInfo> nodeL2 = new LazyOtporeNodeUpsertL2(option.conn, option.schemaName);
		
		otpGenerate.addPostAction(enforceLChanged);				
		enforceLChanged.addPostAction(enforceValidUntil);
		enforceValidUntil.addPostAction(nodeL2);
		
		actions.add(otpGenerate);	
		return actions;
	}
}
