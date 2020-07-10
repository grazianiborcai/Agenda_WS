package br.com.mind5.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.action.LazyPersonapMergeGender;
import br.com.mind5.business.personSnapshot.model.action.StdPersonapMergeToSelect;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckOwner;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPersonapSelect extends DeciTreeTemplateReadV2<PersonapInfo> {
	
	public RootPersonapSelect(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersonapInfo> buildCheckerHook(DeciTreeOption<PersonapInfo> option) {
		List<ModelCheckerV1<PersonapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersonapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersonapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonapInfo> option) {
		List<ActionStdV1<PersonapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonapInfo> select = new StdPersonapMergeToSelect(option);		
		ActionLazyV1<PersonapInfo> mergeGender = new LazyPersonapMergeGender(option.conn, option.schemaName);
		
		select.addPostAction(mergeGender);		
		actions.add(select);
		
		return actions;
	}
}
