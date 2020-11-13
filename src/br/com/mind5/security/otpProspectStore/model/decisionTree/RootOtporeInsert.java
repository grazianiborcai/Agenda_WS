package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeSendEmail;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeSuccess;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckInsert;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckOwner;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckSysotup;

public final class RootOtporeInsert extends DeciTreeTemplateWrite<OtporeInfo> {
	
	public RootOtporeInsert(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelChecker<OtporeInfo>> queue = new ArrayList<>();		
		ModelChecker<OtporeInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OtporeCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OtporeCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OtporeCheckSysotup(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStd<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStd<OtporeInfo> upsert = new NodeOtporeUpsertL1(option).toAction();
		ActionLazy<OtporeInfo> sendEmail = new LazyOtporeSendEmail(option.conn, option.schemaName);
		ActionLazy<OtporeInfo> success = new LazyOtporeSuccess(option.conn, option.schemaName);
		
		upsert.addPostAction(sendEmail);
		sendEmail.addPostAction(success);
		
		actions.add(upsert);	
		return actions;
	}
}
