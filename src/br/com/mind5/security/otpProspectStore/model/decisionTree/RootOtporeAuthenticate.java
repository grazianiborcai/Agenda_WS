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
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeOptValidate;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeDaoDelete;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeMergeToAuthenticate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckAuthenticate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckExist;

public final class RootOtporeAuthenticate extends DeciTreeTemplateWriteV2<OtporeInfo> {
	
	public RootOtporeAuthenticate(DeciTreeOption<OtporeInfo> option) {
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
		checker = new OtporeCheckAuthenticate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OtporeCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStdV1<OtporeInfo>> actions = new ArrayList<>();

		ActionStdV1<OtporeInfo> mergeToAuthenticate = new StdOtporeMergeToAuthenticate(option);
		ActionLazyV1<OtporeInfo> optValidate = new LazyOtporeOptValidate(option.conn, option.schemaName);
		ActionStdV1<OtporeInfo> delete = new StdOtporeDaoDelete(option);
		
		mergeToAuthenticate.addPostAction(optValidate);
		
		actions.add(mergeToAuthenticate);		
		actions.add(delete);
		return actions;
	}
}
