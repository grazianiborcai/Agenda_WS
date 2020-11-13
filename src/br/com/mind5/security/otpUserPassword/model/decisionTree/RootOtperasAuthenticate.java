package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.LazyOtperasOptValidate;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasDaoDelete;
import br.com.mind5.security.otpUserPassword.model.action.StdOtperasMergeToAuthenticate;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckAuthenticate;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckExist;

public final class RootOtperasAuthenticate extends DeciTreeTemplateWriteV2<OtperasInfo> {
	
	public RootOtperasAuthenticate(DeciTreeOption<OtperasInfo> option) {
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
		checker = new OtperasCheckAuthenticate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OtperasCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStdV2<OtperasInfo>> actions = new ArrayList<>();

		ActionStdV2<OtperasInfo> mergeToAuthenticate = new StdOtperasMergeToAuthenticate(option);
		ActionLazy<OtperasInfo> optValidate = new LazyOtperasOptValidate(option.conn, option.schemaName);
		ActionStdV2<OtperasInfo> delete = new StdOtperasDaoDelete(option);
		
		mergeToAuthenticate.addPostAction(optValidate);
		
		actions.add(mergeToAuthenticate);		
		actions.add(delete);
		return actions;
	}
}
