package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeDaoInsert;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeDaoUpdate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckExist;

public final class NodeOtporeUpsertL2 extends DeciTreeTemplateWriteV2<OtporeInfo> {
	
	public NodeOtporeUpsertL2(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelCheckerV1<OtporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtporeInfo> checker;
		ModelCheckerOption checkerOption;	

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new OtporeCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStdV1<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtporeInfo> insert = new StdOtporeDaoInsert(option);
		
		actions.add(insert);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OtporeInfo>> buildActionsOnFailedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStdV1<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtporeInfo> update = new StdOtporeDaoUpdate(option);
		
		actions.add(update);	
		return actions;
	}
}
