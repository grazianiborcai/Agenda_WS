package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeEnforceLChanged;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeEnforceValidUntil;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeNodeUpsertL2;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeOtpGenerate;

public final class NodeOtporeUpsertL1 extends DeciTreeTemplateWriteV2<OtporeInfo> {
	
	public NodeOtporeUpsertL1(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelCheckerV1<OtporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtporeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStdV1<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtporeInfo> otpGenerate = new StdOtporeOtpGenerate(option);
		ActionLazyV1<OtporeInfo> enforceLChanged = new LazyOtporeEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<OtporeInfo> enforceValidUntil = new LazyOtporeEnforceValidUntil(option.conn, option.schemaName);
		ActionLazyV1<OtporeInfo> nodeL2 = new LazyOtporeNodeUpsertL2(option.conn, option.schemaName);
		
		otpGenerate.addPostAction(enforceLChanged);				
		enforceLChanged.addPostAction(enforceValidUntil);
		enforceValidUntil.addPostAction(nodeL2);
		
		actions.add(otpGenerate);	
		return actions;
	}
}
