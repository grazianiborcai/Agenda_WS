package br.com.mind5.security.otpUserPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiDaoInsert;
import br.com.mind5.security.otpUserPassword.model.action.OtperasVisiDaoUpdate;
import br.com.mind5.security.otpUserPassword.model.checker.OtperasCheckExist;

public final class OtperasNodeUpsertL2 extends DeciTreeTemplateWrite<OtperasInfo> {
	
	public OtperasNodeUpsertL2(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtperasInfo> buildCheckerHook(DeciTreeOption<OtperasInfo> option) {
		List<ModelChecker<OtperasInfo>> queue = new ArrayList<>();		
		ModelChecker<OtperasInfo> checker;
		ModelCheckerOption checkerOption;	

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new OtperasCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtperasInfo>> buildActionsOnPassedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStd<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStd<OtperasInfo> insert = new ActionStdCommom<OtperasInfo>(option, OtperasVisiDaoInsert.class);
		
		actions.add(insert);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OtperasInfo>> buildActionsOnFailedHook(DeciTreeOption<OtperasInfo> option) {
		List<ActionStd<OtperasInfo>> actions = new ArrayList<>();
		
		ActionStd<OtperasInfo> update = new ActionStdCommom<OtperasInfo>(option, OtperasVisiDaoUpdate.class);
		
		actions.add(update);	
		return actions;
	}
}
