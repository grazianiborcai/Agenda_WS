package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiDaoDelete;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiMergeToAuthenticate;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiOtpValidate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckAuthenticate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckExist;

public final class OtporeRootAuthenticate extends DeciTreeTemplateWrite<OtporeInfo> {
	
	public OtporeRootAuthenticate(DeciTreeOption<OtporeInfo> option) {
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

		ActionStd<OtporeInfo> mergeToAuthenticate = new ActionStdCommom<OtporeInfo>(option, OtporeVisiMergeToAuthenticate.class);
		ActionLazy<OtporeInfo> optValidate = new ActionLazyCommom<OtporeInfo>(option, OtporeVisiOtpValidate.class);
		ActionStd<OtporeInfo> delete = new ActionStdCommom<OtporeInfo>(option, OtporeVisiDaoDelete.class);
		
		mergeToAuthenticate.addPostAction(optValidate);
		
		actions.add(mergeToAuthenticate);		
		actions.add(delete);
		return actions;
	}
}
