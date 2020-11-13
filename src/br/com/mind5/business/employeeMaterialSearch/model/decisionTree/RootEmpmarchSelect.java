package br.com.mind5.business.employeeMaterialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.action.StdEmpmarchMergeToSelect;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckLangu;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckOwner;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpmarchSelect extends DeciTreeTemplateReadV2<EmpmarchInfo> {
	
	public RootEmpmarchSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpmarchInfo> buildCheckerHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ModelCheckerV1<EmpmarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ActionStdV2<EmpmarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpmarchInfo> select = new StdEmpmarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
