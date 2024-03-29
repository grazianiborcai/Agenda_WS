package br.com.mind5.security.otpProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiDaoInsert;
import br.com.mind5.security.otpProspectStore.model.action.OtporeVisiDaoUpdate;
import br.com.mind5.security.otpProspectStore.model.checker.OtporeCheckExist;

public final class OtporeNodeUpsertL2 extends DeciTreeTemplateWrite<OtporeInfo> {
	
	public OtporeNodeUpsertL2(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtporeInfo> buildCheckerHook(DeciTreeOption<OtporeInfo> option) {
		List<ModelChecker<OtporeInfo>> queue = new ArrayList<>();		
		ModelChecker<OtporeInfo> checker;
		ModelCheckerOption checkerOption;	

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new OtporeCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtporeInfo>> buildActionsOnPassedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStd<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStd<OtporeInfo> insert = new ActionStdCommom<OtporeInfo>(option, OtporeVisiDaoInsert.class);
		
		actions.add(insert);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OtporeInfo>> buildActionsOnFailedHook(DeciTreeOption<OtporeInfo> option) {
		List<ActionStd<OtporeInfo>> actions = new ArrayList<>();
		
		ActionStd<OtporeInfo> update = new ActionStdCommom<OtporeInfo>(option, OtporeVisiDaoUpdate.class);
		
		actions.add(update);	
		return actions;
	}
}
