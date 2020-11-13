package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasMergeUselis;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasSendEmail;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasSuccess;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasSuccess;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckUsername;

public final class NodeOtperasInsert extends DeciTreeTemplateWrite<OtperasInfo> {
	
	public NodeOtperasInsert(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtperasInfo> buildCheckerHook(DeciTreeOption<OtperasInfo> option) {
		List<ModelChecker<OtperasInfo>> queue = new ArrayList<>();		
		ModelChecker<OtperasInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OtperasCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStd<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStd<OtperasInfo> upsert = new NodeOtperasUpsertL1(option).toAction();
		ActionLazy<OtperasInfo> mergeUselis = new LazyOtperasMergeUselis(option.conn, option.schemaName);
		ActionLazy<OtperasInfo> sendEmail = new LazyOtperasSendEmail(option.conn, option.schemaName);
		ActionLazy<OtperasInfo> success = new LazyOtperasSuccess(option.conn, option.schemaName);
		
		upsert.addPostAction(mergeUselis);
		mergeUselis.addPostAction(sendEmail);
		sendEmail.addPostAction(success);
		
		actions.add(upsert);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OtperasInfo>> buildActionsOnFailedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStd<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStd<OtperasInfo> success = new StdOtperasSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
