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
import br.com.mind5.security.otpProspectStore.model.action.LazyUpswdNodeEmailL2;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeOtpGenerate;

public final class NodeUpswdEmailL1 extends DeciTreeTemplateWriteV2<OtporeInfo> {
	
	public NodeUpswdEmailL1(DeciTreeOption<OtporeInfo> option) {
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
		
		ActionStdV1<OtporeInfo> mergeUselis = new StdOtporeOtpGenerate(option);
		ActionLazyV1<OtporeInfo> nodeL2 = new LazyUpswdNodeEmailL2(option.conn, option.schemaName);
		
		mergeUselis.addPostAction(nodeL2);
		
		actions.add(mergeUselis);		
		return actions;
	}
}
