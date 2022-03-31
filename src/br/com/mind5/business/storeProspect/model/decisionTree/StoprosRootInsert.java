package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiRootSelect;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiDaoInsert;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiEnforceCreated;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiEnforceCreatedOn;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiEnforceLChanged;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiOtporeAuthenticate;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckInsert;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckOwner;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckSysotup;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoprosRootInsert extends DeciTreeTemplateWrite<StoprosInfo> {
	
	public StoprosRootInsert(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprosInfo> buildCheckerHook(DeciTreeOption<StoprosInfo> option) {
		List<ModelChecker<StoprosInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprosInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoprosCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckSysotup(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprosInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosInfo> option) {
		List<ActionStd<StoprosInfo>> actions = new ArrayList<>();
		
		ActionStd<StoprosInfo> otporeAuthenticate = new ActionStdCommom<StoprosInfo>(option, StoprosVisiOtporeAuthenticate.class);
		ActionLazy<StoprosInfo> enforceCreated = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiEnforceCreated.class);
		ActionLazy<StoprosInfo> enforceCreatedOn = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiEnforceCreatedOn.class);
		ActionLazy<StoprosInfo> enforceLChanged = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiEnforceLChanged.class);
		ActionLazy<StoprosInfo> insert = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiDaoInsert.class);
		ActionLazy<StoprosInfo> select = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiRootSelect.class);
		
		otporeAuthenticate.addPostAction(enforceCreated);
		enforceCreated.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(otporeAuthenticate);
		return actions;
	}
}
