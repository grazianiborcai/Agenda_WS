package br.com.mind5.security.otpUserPassword.model.decisionTree;

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
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiDaoDelete;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiMergeToAuthenticate;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiOtpValidate;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckAuthenticate;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckExist;

public final class OtperasRootAuthenticate extends DeciTreeTemplateWrite<OtperasInfo> {
	
	public OtperasRootAuthenticate(DeciTreeOption<OtperasInfo> option) {
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
		checker = new OtperasCheckAuthenticate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OtperasCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStd<OtperasInfo>> actions = new ArrayList<>();

		ActionStd<OtperasInfo> mergeToAuthenticate = new ActionStdCommom<OtperasInfo>(option, OtperasVisiMergeToAuthenticate.class);
		ActionLazy<OtperasInfo> otpValidate = new ActionLazyCommom<OtperasInfo>(option, OtperasVisiOtpValidate.class);
		ActionStd<OtperasInfo> delete = new ActionStdCommom<OtperasInfo>(option, OtperasVisiDaoDelete.class);
		
		mergeToAuthenticate.addPostAction(otpValidate);
		
		actions.add(mergeToAuthenticate);		
		actions.add(delete);
		return actions;
	}
}
