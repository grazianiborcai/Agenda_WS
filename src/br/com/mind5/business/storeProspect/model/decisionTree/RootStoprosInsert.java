package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosDaoInsert;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceCreated;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceCreatedOn;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosRootSelect;
import br.com.mind5.business.storeProspect.model.action.StdStoprosOtporeAuthenticate;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckInsert;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckOwner;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoprosInsert extends DeciTreeTemplateWriteV2<StoprosInfo> {
	
	public RootStoprosInsert(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoprosInfo> buildCheckerHook(DeciTreeOption<StoprosInfo> option) {
		List<ModelCheckerV1<StoprosInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoprosInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoprosInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosInfo> option) {
		List<ActionStdV1<StoprosInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoprosInfo> otporeAuthenticate = new StdStoprosOtporeAuthenticate(option);
		ActionLazyV1<StoprosInfo> enforceCreated = new LazyStoprosEnforceCreated(option.conn, option.schemaName);
		ActionLazyV1<StoprosInfo> enforceCreatedOn = new LazyStoprosEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<StoprosInfo> insert = new LazyStoprosDaoInsert(option.conn, option.schemaName);
		ActionLazyV1<StoprosInfo> select = new LazyStoprosRootSelect(option.conn, option.schemaName);
		
		otporeAuthenticate.addPostAction(enforceCreated);
		enforceCreated.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(otporeAuthenticate);
		return actions;
	}
}
