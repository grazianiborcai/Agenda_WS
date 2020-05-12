package br.com.mind5.business.personList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.action.StdPersolisMergeToSelect;
import br.com.mind5.business.personList.model.checker.PersolisCheckLangu;
import br.com.mind5.business.personList.model.checker.PersolisCheckOwner;
import br.com.mind5.business.personList.model.checker.PersolisCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPersolisSelect extends DeciTreeTemplateReadV2<PersolisInfo> {
	
	public RootPersolisSelect(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersolisInfo> buildCheckerHook(DeciTreeOption<PersolisInfo> option) {
		List<ModelCheckerV1<PersolisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersolisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersolisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersolisCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersolisCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersolisInfo>> buildActionsOnPassedHook(DeciTreeOption<PersolisInfo> option) {
		List<ActionStdV1<PersolisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersolisInfo> select = new StdPersolisMergeToSelect(option);		
		actions.add(select);
		
		return actions;
	}
}
