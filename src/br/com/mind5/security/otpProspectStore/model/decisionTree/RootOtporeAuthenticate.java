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
import br.com.mind5.security.otpProspectStore.model.action.LazyOtporeOptValidate;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeDaoDelete;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeMergeToAuthenticate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckAuthenticate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckExist;

public final class RootOtporeAuthenticate extends DeciTreeTemplateWrite<OtporeInfo> {
	
	public RootOtporeAuthenticate(DeciTreeOption<OtporeInfo> option) {
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
		checker = new OtporeCheckAuthenticate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OtporeCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStd<OtporeInfo>> actions = new ArrayList<>();

		ActionStd<OtporeInfo> mergeToAuthenticate = new StdOtporeMergeToAuthenticate(option);
		ActionLazy<OtporeInfo> optValidate = new LazyOtporeOptValidate(option.conn, option.schemaName);
		ActionStd<OtporeInfo> delete = new StdOtporeDaoDelete(option);
		
		mergeToAuthenticate.addPostAction(optValidate);
		
		actions.add(mergeToAuthenticate);		
		actions.add(delete);
		return actions;
	}
}
