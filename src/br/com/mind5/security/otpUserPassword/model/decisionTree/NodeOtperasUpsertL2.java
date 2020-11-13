package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasDaoInsert;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasDaoUpdate;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckExist;

public final class NodeOtperasUpsertL2 extends DeciTreeTemplateWriteV2<OtperasInfo> {
	
	public NodeOtperasUpsertL2(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtperasInfo> buildCheckerHook(DeciTreeOption<OtperasInfo> option) {
		List<ModelCheckerV1<OtperasInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtperasInfo> checker;
		ModelCheckerOption checkerOption;	

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new OtperasCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStdV2<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OtperasInfo> insert = new StdOtperasDaoInsert(option);
		
		actions.add(insert);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<OtperasInfo>> buildActionsOnFailedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStdV2<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OtperasInfo> update = new StdOtperasDaoUpdate(option);
		
		actions.add(update);	
		return actions;
	}
}
