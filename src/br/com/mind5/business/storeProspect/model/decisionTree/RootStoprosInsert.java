package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosCheckSysotup;
import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosDaoInsert;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceCreated;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceCreatedOn;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceLChanged;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosRootSelect;
import br.com.mind5.business.storeProspect.model.action.StdStoprosOtporeAuthenticate;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckInsert;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStoprosInsert extends DeciTreeTemplateWrite<StoprosInfo> {
	
	public RootStoprosInsert(DeciTreeOption<StoprosInfo> option) {
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
		
		ActionStd<StoprosInfo> otporeAuthenticate = new StdStoprosOtporeAuthenticate(option);
		ActionLazy<StoprosInfo> enforceCreated = new LazyStoprosEnforceCreated(option.conn, option.schemaName);
		ActionLazy<StoprosInfo> enforceCreatedOn = new LazyStoprosEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StoprosInfo> enforceLChanged = new LazyStoprosEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoprosInfo> insert = new LazyStoprosDaoInsert(option.conn, option.schemaName);
		ActionLazy<StoprosInfo> select = new LazyStoprosRootSelect(option.conn, option.schemaName);
		
		otporeAuthenticate.addPostAction(enforceCreated);
		enforceCreated.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(otporeAuthenticate);
		return actions;
	}
}
