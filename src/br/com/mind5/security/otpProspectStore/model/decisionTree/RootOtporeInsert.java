package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeSendEmail;
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeSuccess;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckInsert;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckOwner;

public final class RootOtporeInsert extends DeciTreeTemplateWriteV2<OtporeInfo> {
	
	public RootOtporeInsert(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelCheckerV1<OtporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtporeInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStdV1<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OtporeInfo> upsert = new NodeOtporeUpsertL1(option).toAction();
		ActionLazyV1<OtporeInfo> sendEmail = new LazyOtporeSendEmail(option.conn, option.schemaName);
		ActionLazyV1<OtporeInfo> success = new LazyOtporeSuccess(option.conn, option.schemaName);
		
		upsert.addPostAction(sendEmail);
		sendEmail.addPostAction(success);
		
		actions.add(upsert);	
		return actions;
	}
}
