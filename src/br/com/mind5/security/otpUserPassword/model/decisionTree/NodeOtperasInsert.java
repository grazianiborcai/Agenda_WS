package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasMergeUselis;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasSendEmail;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasSuccess;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasSuccess;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckUsername;

public final class NodeOtperasInsert extends DeciTreeTemplateWriteV2<OtperasInfo> {
	
	public NodeOtperasInsert(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtperasInfo> buildCheckerHook(DeciTreeOption<OtperasInfo> option) {
		List<ModelCheckerV1<OtperasInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtperasInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OtperasCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStdV1<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtperasInfo> upsert = new NodeOtperasUpsertL1(option).toAction();
		ActionLazyV1<OtperasInfo> mergeUselis = new LazyOtperasMergeUselis(option.conn, option.schemaName);
		ActionLazyV1<OtperasInfo> sendEmail = new LazyOtperasSendEmail(option.conn, option.schemaName);
		ActionLazyV1<OtperasInfo> success = new LazyOtperasSuccess(option.conn, option.schemaName);
		
		upsert.addPostAction(mergeUselis);
		mergeUselis.addPostAction(sendEmail);
		sendEmail.addPostAction(success);
		
		actions.add(upsert);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OtperasInfo>> buildActionsOnFailedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStdV1<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtperasInfo> success = new StdOtperasSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
